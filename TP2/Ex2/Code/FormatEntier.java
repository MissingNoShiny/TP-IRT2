public class FormatEntier implements Format {
    @Override
    public boolean isValide(String txt) {
        try {
            int n = Integer.parseInt(txt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
