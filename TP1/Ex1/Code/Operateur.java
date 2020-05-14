public enum Operateur {
    ADDITION,
    SOUSTRACTION,
    MULTIPLICATION;

    @Override
    public String toString() {
        switch (this) {
            case ADDITION:
                return "+";
            case SOUSTRACTION:
                return "-";
            case MULTIPLICATION:
                return "*";
        }
        return "";
    }
}
