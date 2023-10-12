import java.util.*;

public class NoteBook extends Product implements Comparable<NoteBook> {
    //Notebookların sıralama, ekleme, silme işlemleri burada yapılıyor.
    static ArrayList<NoteBook> noteBooks = new ArrayList<>();
    private static int count = 100;

    public NoteBook(double price, double discountRate, int amountOfStock, int storage, double screenSize, int RAM, String name, Brand brand) {
        super(count, price, discountRate, amountOfStock, storage, screenSize, RAM, name, brand);
        plusOneCount();
    }

    private void plusOneCount() {
        count = count + 1;
    }

    @Override
    public int compareTo(NoteBook o) {
        return this.getBrand().getName().compareTo(o.getBrand().getName());
    }

    static {
        noteBooks.add(new NoteBook(8235.2, 15, 150, 512, 14.0, 16, "HUAWEI Matebook 14", new Brand("Huawei")));
        noteBooks.add(new NoteBook(4623.75, 20, 100, 1024, 14.0, 8, "LENOVO V14 IGL ", new Brand("Lenovo")));
        noteBooks.add(new NoteBook(9110, 10, 120, 2048, 15.6, 32, "ASUS Tuf Gaming", new Brand("Asus")));
    }

    public static void printNoteBook() {
        Collections.sort(noteBooks);
        System.out.format("-----------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM  | %n");
        System.out.format("-----------------------------------------------------------------------------------------%n");
        for (NoteBook noteBook : noteBooks) {
            System.out.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d  |%n",
                    noteBook.getId(), noteBook.getName(), Math.ceil(noteBook.getPrice() * (100 - noteBook.getDiscountRate()) / 100), noteBook.getBrand().getName(),
                    noteBook.getStorage(), noteBook.getScreenSize(), noteBook.getRAM());
        }

        System.out.format("-----------------------------------------------------------------------------------------%n");
    }

    public static void printNotebookByID() {
        TreeSet<NoteBook> noteBooksByID = new TreeSet<>(new OrderByIDNotebook());
        noteBooksByID.addAll(noteBooks);
        System.out.format("-----------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM  | %n");
        System.out.format("-----------------------------------------------------------------------------------------%n");
        for (NoteBook noteBook : noteBooksByID) {
            System.out.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d  |%n",
                    noteBook.getId(), noteBook.getName(), Math.ceil(noteBook.getPrice() * (100 - noteBook.getDiscountRate()) / 100), noteBook.getBrand().getName(),
                    noteBook.getStorage(), noteBook.getScreenSize(), noteBook.getRAM());
        }

        System.out.format("-----------------------------------------------------------------------------------------%n");

    }

    public static void addNoteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Eklemek istediğiniz ürünün özelliklerini giriniz.");
        System.out.print("Ürünün fiyatı: ");
        double priceChoice = input.nextDouble();
        System.out.print("Ürünün indirim oranı: ");
        double discountRateChoice = input.nextDouble();
        System.out.print("Ürünün stoğu: ");
        int amountChoice = input.nextInt();
        System.out.print("Ürünün Hafızası: ");
        int storageChoice = input.nextInt();
        System.out.print("Ürünün Ekran boyutu: ");
        double screenSizeChoice = input.nextDouble();
        System.out.print("Ürünün RAMİ: ");
        int RAMChoice = input.nextInt();
        input.nextLine();
        System.out.print("Ürünün İsmi: ");
        String nameChoice = input.nextLine();



        int counter = 1;
        for (Brand brand : Brand.brands) {
            System.out.println(counter++ + " - " + brand.getName());
        }
        System.out.println("Ürünün markasının ID sini girin: ");
        int selectID = input.nextInt();
        String selected = null;
        switch (selectID) {
            case 1:
                selected = "Apple";
                break;
            case 2:
                selected = "Asus";
                break;
            case 3:
                selected = "Casper";
                break;
            case 4:
                selected = "HP";
                break;
            case 5:
                selected = "Huawei";
                break;
            case 6:
                selected = "Lenovo";
                break;
            case 7:
                selected = "Monster";
                break;
            case 8:
                selected = "Samsung";
                break;
            default:
                selected = "Xiaomi";
                break;

        }


        noteBooks.add(new NoteBook(priceChoice, discountRateChoice, amountChoice, storageChoice, screenSizeChoice, RAMChoice, nameChoice, Brand.getBrand(selected)));
        System.out.println("Ürün Eklendi.");
        listNoteBooks();
    }

    public static void deleteNotebook() {
        Scanner input = new Scanner(System.in);
        printNotebookByID();
        System.out.println("Silmek istediğiniz ID: ");

        int delete = input.nextInt();

        Iterator<NoteBook> iterator = noteBooks.iterator();
        while (iterator.hasNext()) {
            NoteBook noteBook = iterator.next();
            if (noteBook.getId() == delete) {
                iterator.remove();
                System.out.println("Silindi");
            }
        }
        listNoteBooks();


    }

    public static void listNoteBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ürün adına göre sıralamak için 1'e , ID'ye göre sıralamak için 2 ye basın: ");
        int list = input.nextInt();
        switch (list) {
            case 1:
                NoteBook.printNoteBook();
                break;
            case 2:
                NoteBook.printNotebookByID();
                break;
        }


    }

    public static void filterNoteBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Markaya göre filtrelemek için 1'e , ID'ye göre filtrelemek için 2 ye basın: ");
        int filter = input.nextInt();
        switch (filter) {
            case 1:
                NoteBook.filterByBrand();
                break;
            case 2:
                NoteBook.filterByID();

        }
    }

    public static void filterByBrand() {
        Scanner input = new Scanner(System.in);
        int counter = 1;
        for (Brand brand : Brand.brands) {
            System.out.println(counter++ + " - " + brand.getName());
        }
        System.out.println("Filtrelemek istediğiniz ürünün ID'sini girin. ");
        int selectID = input.nextInt();
        String filterBrand = null;
        switch (selectID) {
            case 1:
                filterBrand = "Apple";
                break;
            case 2:
                filterBrand = "Asus";
                break;
            case 3:
                filterBrand = "Casper";
                break;
            case 4:
                filterBrand = "HP";
                break;
            case 5:
                filterBrand = "Huawei";
                break;
            case 6:
                filterBrand = "Lenovo";
                break;
            case 7:
                filterBrand = "Monster";
                break;
            case 8:
                filterBrand = "Samsung";
                break;
            default:
                filterBrand = "Xiaomi";
                break;

        }
        boolean isFound = false;
        System.out.format("-----------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM  | %n");
        System.out.format("-----------------------------------------------------------------------------------------%n");
        for (NoteBook noteBook : noteBooks) {
            if (filterBrand.equals(noteBook.getBrand().getName())) {
                System.out.println(noteBook.toString());
                isFound = true;
            }
        }
        System.out.format("-----------------------------------------------------------------------------------------%n");
        if (!isFound) {
            System.out.println("Seçtiğiniz markada ürün bulunmamaktadır.");
        }


    }

    public static void filterByID() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ürünün ID' sini girin.");
        int IDNo = input.nextInt();
        System.out.format("-----------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM  | %n");
        System.out.format("-----------------------------------------------------------------------------------------%n");
        boolean isFound = false;
        for (NoteBook noteBook : noteBooks) {
            if (IDNo == noteBook.getId()) {
                System.out.println(noteBook.toString());
                isFound = true;

            }
        }
        System.out.format("-----------------------------------------------------------------------------------------%n");
        if (!isFound) {
            System.out.println("Seçtiğiniz ID ' de ürün bulunmamaktadır.");
        }

        
    }
    @Override
    public String toString() {
        return String.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d  |",
                getId(), getName(), Math.ceil(getPrice() * (100 - getDiscountRate()) / 100), getBrand().getName(),
                getStorage(), getScreenSize(), getRAM());
    }


}
