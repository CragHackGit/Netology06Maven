public class BonusService {

    public long calcBonus(long amount, boolean isRegistered) {
        long percent = isRegistered ? 3 : 1;
        long bonus = amount * percent / 100;
        if (bonus > 500) {
            bonus = 500;
        }
        return bonus;
    }
}
