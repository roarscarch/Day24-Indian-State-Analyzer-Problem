package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateAnalyzerTest {

    @Test
    public void HappyTestCount() {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser("StateCensus.csv");
        int count = stateCensusAnalyzer.countOfRecords();
        assertEquals(count, 37);
    }


    @Test
    public void SadTest() {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser("StateCensus.csv");
        int count = 3838;
        assertEquals(37, count);
    }


    @Test
    public void testFileType() {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser("StateCensus.txt");
        assertEquals(37, stateCensusAnalyzer.countOfRecords());
    }


    @Test
    public void testDelimiter() {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser("StateCensus2.csv");
        stateCensusAnalyzer.countOfRecords();
    }


    @Test
    public void testHeader() {
        StateCensusAnalyser stateCensusAnalyzer = new StateCensusAnalyser("StateCensus3.csv");
        stateCensusAnalyzer.countOfRecords();
    }
}
