package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateAnalyzerTest {
    // Test case 1.1
    @Test
    public void testDataCountHappy() throws StateCensusException {
        StateCensusAnalyser analyzer = new StateCensusAnalyser("StateCensus.csv");
        int count = analyzer.countOfRecords();
        assertEquals(count, 37);
    }

    // Test 1.2
    @Test
    public void testDataCountSad() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser("StateCensus.csv");
        int count = 3838;
        assertEquals(37, count);

    }

    // Test 1.3
    @Test
    public void testFileType() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser("StateCensus.txt");

        assertEquals(37, analyzer.countOfRecords());
    }

    // Test 1.4
    @Test
    public void testDelimiter() {
        StateCensusAnalyser analyzer= new StateCensusAnalyser("StateCensus2.csv");
        analyzer.countOfRecords();
    }

    // Test 1.5
    @Test
    public void testHeader() {
        StateCensusAnalyser analyzer = new StateCensusAnalyser("StateCensus3.csv");
        analyzer.countOfRecords();
    }

}