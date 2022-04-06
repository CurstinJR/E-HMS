package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BillTest
{
    Bill bill1;
    Bill bill2;

    @BeforeEach
    void setUp()
    {
        bill1 = new Bill.Builder()
                .billId(1L)
                .billAmount(BigDecimal.valueOf(299.99))
                .billDescription("Bill for patient zero: Bought 1 cough syrup")
                .billDate(LocalDate.of(2022, 5, 15))
                .build();

        bill2 = new Bill.Builder()
                .billId(2L)
                .billAmount(BigDecimal.valueOf(199.99))
                .billDescription("Bill for patient one: Bought 2 cough syrups")
                .billDate(LocalDate.of(2022, 3, 10))
                .build();
    }

    @Test
    public void billBuilderTest_shouldEqual()
    {
        Bill bill1Copy = new Bill.Builder()
                .copy(bill1);

        assertEquals(bill1, bill1Copy);
    }

    @Test
    public void patientBuilderTest_shouldNotEqual()
    {
        assertNotEquals(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldBeSame()
    {
        Bill bill1Copy = new Bill.Builder()
                .copy(bill1);

        assertSame(bill1, bill1Copy);
    }

    @Test
    public void patientBuilderTest_shouldNotBeSame()
    {
        assertNotSame(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldNotEqualHash()
    {
        for (long i = 0L; i < 100L; i++)
        {
            Bill bill1 = new Bill.Builder()
                    .billId(i)
                    .build();

            Bill bill2 = new Bill.Builder()
                    .billId(i + 1)
                    .build();

            assertNotEquals(bill1.hashCode(), bill2.hashCode());
        }
    }

    @Test
    public void patientBuilderTest_shouldEqualHash()
    {
        Bill bill1Copy = new Bill.Builder()
                .copy(bill1);

        assertEquals(bill1, bill1Copy);
    }
}