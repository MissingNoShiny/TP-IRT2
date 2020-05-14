public class FormatMail implements Format {
    @Override
    public boolean isValide(String txt) {
        return txt.contains("@");
    }
}
