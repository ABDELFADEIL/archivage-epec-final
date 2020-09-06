package org.simplon.epec.archivage.domain.client.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    private Client clientUnderTest;
    @BeforeEach
    void setUp() {
        clientUnderTest = new Client(1,
                "client_number", "CLAUD",
                "Eric", 0,
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
                "birth_dept", "siren_number", "siret_number",
                "user_id");
    }
    @Test
    void testToString() {
        // Setup
        // Run the test
        final String name = clientUnderTest.getClient_name();

        // Verify the results
        assertThat(name).isEqualTo("CLAUD");
    }



}
