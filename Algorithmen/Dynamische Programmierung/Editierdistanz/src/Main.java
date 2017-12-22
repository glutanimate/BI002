public class Main {
    public static void main(String[] args) {
        EditDistance edt = new EditDistance();
        int ret = edt.distance("apfel", "pferd");
        System.out.println(ret);
    }
}

