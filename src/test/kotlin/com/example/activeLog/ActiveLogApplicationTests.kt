package com.example.activeLog

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class ActiveLogApplicationTests {
	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun get() {
		mockMvc.get("/api").andExpect {
			status { isOk() }
			content {
				contentTypeCompatibleWith("text/plain")
				string("Hello World!")
			}
		}
	}

	@Test
	fun post() {
		mockMvc.post("/api") {
			param("value", "hello")
		}.andExpect {
			status { isOk() }
			content {
				string("hello")
			}
		}.andDo {
			print()
			handle {
				println(it.response.characterEncoding)
			}
		}
	}

}
