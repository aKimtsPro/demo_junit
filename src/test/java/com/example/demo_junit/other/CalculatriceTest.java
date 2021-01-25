package com.example.demo_junit.other;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


class CalculatriceTest {

    private Calculatrice calc = Calculatrice.instance();

    @Test
    void add() {
        assertEquals(5,calc.add(2,2));
    }

    @Test
    void divide() {
        assertEquals(2, calc.divide(5,2));
    }

    @Test
    void divide_byZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5,0));
    }

    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(2000), () -> {Thread.sleep(1000);});
    }

    @Test
    void testTimeOutPreemptive(){
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {while(true);});
    }

    @Test
    void instaFail(){
        fail("mon petit message");
    }

    // assertEquals             => vérifie l'egalité via la méthode 'equals'
    // assertSame               => vérifie que 2 objets sont bien les mêmes ( == )
    // assertTrue/assertFalse   => vérifie qu'un est vrai ou faux
    // assertNull               => vérifie qu'un élément est null
    // assertThrows             => vérifie le bon lancement d'une exception spécifique
    // assertTimeOut(Preemptively)=> vérifie qu'une fonction s'exécute dans le temps imparti (coupe si Preemptively)
}
