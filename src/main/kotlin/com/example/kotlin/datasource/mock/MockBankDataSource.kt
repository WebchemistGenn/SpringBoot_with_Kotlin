package com.example.kotlin.datasource.mock

import com.example.kotlin.datasource.BankDataSource
import com.example.kotlin.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource: BankDataSource {

    val banks = listOf(
        Bank("1234", 3.14, 17),
        Bank("4567", 17.0, 1),
        Bank("5678", 1.0, 100))

    override fun retrieveBanks(): Collection<Bank>  = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull() { it.accountNumber == accountNumber } ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
}