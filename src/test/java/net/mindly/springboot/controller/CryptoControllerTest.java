package net.mindly.springboot.controller;

import net.mindly.springboot.model.Crypto;
import net.mindly.springboot.repository.CryptoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CryptoController.class)
class CryptoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CryptoRepository mockCryptoRepository;

	@Test
	void testGetAllCrypto() throws Exception {

		final List<Crypto> cryptos = Arrays.asList(new Crypto("cryptocurrency", new BigDecimal("0.00"),
				"dateOfPurchase", "walletLocation", new BigDecimal("0.00"), "option"));
		when(mockCryptoRepository.findAll()).thenReturn(cryptos);

		final MockHttpServletResponse response = mockMvc.perform(get("/api/crypto").accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).contains("cryptocurrency");
	}

	@Test
	void testAddCrypto() throws Exception {
// Setup

// Configure CryptoRepository.save(...).
		final Crypto crypto = new Crypto("cryptocurrency", new BigDecimal("0.00"), "dateOfPurchase", "walletLocation",
				new BigDecimal("0.00"), "option");
		when(mockCryptoRepository.save(any(Crypto.class))).thenReturn(crypto);

// Run the test
		final MockHttpServletResponse response = mockMvc.perform(post("/api/crypto").content("content")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

// Verify the results
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
	}

	@Test
	void testDeleteCrypto() throws Exception {
// Setup

// Configure CryptoRepository.findById(...).
		final Optional<Crypto> crypto = Optional.of(new Crypto("cryptocurrency", new BigDecimal("0.00"),
				"dateOfPurchase", "walletLocation", new BigDecimal("0.00"), "option"));
		when(mockCryptoRepository.findById(0L)).thenReturn(crypto);

// Run the test
		final MockHttpServletResponse response = mockMvc
				.perform(delete("/api/crypto/{id}", 0).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

// Verify the results
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
		verify(mockCryptoRepository).delete(any(Crypto.class));
	}
}