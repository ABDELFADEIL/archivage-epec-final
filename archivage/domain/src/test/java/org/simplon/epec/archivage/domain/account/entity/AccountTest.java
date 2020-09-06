package org.simplon.epec.archivage.domain.account.entity;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.simplon.epec.archivage.domain.client.entity.Client;

import static org.mockito.MockitoAnnotations.initMocks;

class AccountTest {

    @Mock
    private Client mockClient;

    private Account accountUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        accountUnderTest = new Account("account_id_type_code", "account_id_type_label", "account_number", mockClient, "user_id");
    }
}
