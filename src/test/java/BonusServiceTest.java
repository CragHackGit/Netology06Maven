import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calcBonus(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateUpperBorderForRegistered() {
        BonusService service = new BonusService();

        long amount = 16634;
        boolean registered = true;
        long expected = 499;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateLowerBorderForRegistered() {
        BonusService service = new BonusService();

        long amount = 34;
        boolean registered = true;
        long expected = 1;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateUpperBorderForUnregistered() {
        BonusService service = new BonusService();

        long amount = 49990;
        boolean registered = false;
        long expected = 499;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateLowerBorderForUnregistered() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateZeroForRegistered() {
        BonusService service = new BonusService();

        long amount = 33;
        boolean registered = true;
        long expected = 0;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateZeroForUnregistered() {
        BonusService service = new BonusService();

        long amount = 99;
        boolean registered = false;
        long expected = 0;

        long actual = service.calcBonus(amount, registered);

        assertEquals(expected, actual);
    }
}