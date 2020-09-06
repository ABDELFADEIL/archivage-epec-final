package org.simplon.epec.archivage.exposition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.MockitoAnnotations.initMocks;

class ExpositionApplicationTest {

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    @InjectMocks
    private ExpositionApplication expositionApplicationUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testRun() throws Exception {
        // Setup

        // Run the test
        expositionApplicationUnderTest.run("args");

        // Verify the results
    }

    @Test
    void testRun_ThrowsException() {
        // Setup

        // Run the test
        assertThatThrownBy(() -> {
            expositionApplicationUnderTest.run("args");
        }).isInstanceOf(Exception.class).hasMessageContaining("message");
    }

    @Test
    void testBCryptPasswordEncoder() {
        // Setup

        // Run the test
        final BCryptPasswordEncoder result = expositionApplicationUnderTest.bCryptPasswordEncoder();

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        ExpositionApplication.main(new String[]{"value"});

        // Verify the results
    }
}
