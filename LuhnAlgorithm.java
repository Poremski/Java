public class LuhnAlgorithm {

    private String digitSequence;
    private byte checkSum;
    private byte nextCheckDigit;

    public LuhnAlgorithm() {
        digitSequence = "0";
        checkSum = 0;
        nextCheckDigit = 0;
    }

    private int calculate(int nbr) {
        int n = nbr*2;
        if (n > 9) {
            n = (n % 10) + 1;
        }
        return n;
    }

    public void setDigitSequence(String digitSequence) {
        if (digitSequence.isEmpty()) {
            digitSequence = "0";
        } else {
            this.digitSequence = digitSequence;
        }
        int sum = 0;
        int check = 0;
        boolean alternate = false;
        for (int i=digitSequence.length() - 1; i >= 0; i--) {

            int n = Integer.parseInt(digitSequence.substring(i, i+1));

            if (alternate) {
                sum += calculate(n);
                check += n;
            } else {
                check += calculate(n);
                sum += n;
            }
            alternate = !alternate;
        }
        checkSum = (byte) (sum%10);
        if (check%10 != 0) {
            nextCheckDigit = (byte) (10 - check % 10);
        } else {
            nextCheckDigit = 0;
        }
    }

    public String getDigitSequence() {
        return digitSequence;
    }

    public byte getCheckSum() {
        return checkSum;
    }

    public byte getNextCheckDigit() {
        return nextCheckDigit;
    }
}
