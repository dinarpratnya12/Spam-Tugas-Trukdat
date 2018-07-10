import java.util.Scanner;

public class Menu {
    LinkedList dll = new LinkedList();



    public void menu() {
        char ch;
        do{

            Scanner sc = new Scanner(System.in);
            System.out.println("Memilih menu");
            System.out.println("1.  Tambah awal");
            System.out.println("2.  Tambah akhir");
            System.out.println("3.  Tambah Data Indeks Tertentu");
            System.out.println("4.  Hapus awal");
            System.out.println("5.  Hapus akhir");
            System.out.println("6.  Hapus Indeks Tertentu");
            System.out.println("7.  Cetak data");
            System.out.println("8.  Cari");
            System.out.println("9.  Sorting Ascending Untuk Nim");
            System.out.println("10. Sorting Decending Untuk Nim");
            System.out.println("11. Sorting Ascending Untuk Nilai");
            System.out.println("12. Sorting Decending Untuk Nilai");
            System.out.println("13. Keluar");
            System.out.print("Pilihan anda : ");
            int pil = sc.nextInt();
            try {

                if (pil == 1) {
                    System.out.print("Masukkan nama : ");
                    String nama = sc.next();
                    System.out.print("Masukan jurusan : ");
                    String alamat = sc.next();
                    System.out.print("Masukkan nilai : ");
                    int bil = sc.nextInt();
                    System.out.print("Masukan nim : ");
                    int nim = sc.nextInt();
                    dll.addFirst(bil, nim, nama, alamat);
                } else if (pil == 2) {
                    System.out.print("Masukkan nama : ");
                    String nama = sc.next();
                    System.out.print("Masukan jurusan : ");
                    String alamat = sc.next();
                    System.out.print("Masukkan nilai : ");
                    int bil = sc.nextInt();
                    System.out.print("Masukan nim : ");
                    int nim = sc.nextInt();
                    dll.addLast(bil, nim, nama, alamat);

                } else if (pil == 3) {
                    System.out.print("Masukkan nama : ");
                    String nama = sc.next();
                    System.out.print("Masukan jurusan : ");
                    String alamat = sc.next();
                    System.out.print("Masukkan nilai : ");
                    int bil = sc.nextInt();
                    System.out.println("Masukan nim : ");
                    int nim = sc.nextInt();
                    System.out.print("Masukkan indeks yang anda tuju : ");
                    int index = sc.nextInt();
                    dll.add(bil, nim, nama, alamat, index);

                } else if (pil == 4) {
                    dll.removeFirst();

                } else if (pil == 5) {
                    dll.removeLast();
                } else if (pil == 6) {
                    System.out.println("Masukkan indeks yang akan dihapus");
                    int index = sc.nextInt();
                    dll.remove(index);

                } else if (pil == 7) {
                    dll.print();

                } else if (pil == 8) {
                    Node tmp = null;
                    System.out.println("Masukkan nama yang akan dicari");
                    String key = sc.next();

                    tmp = dll.getKey(key);
                    if (tmp != null) {
                        int index = dll.getIndex(tmp);
                        System.out.println("Berada di index " + index);

                    } else {
                        System.out.println("Maaf nilai yang anda cari tidak ditemukan !");
                    }

                } else if (pil == 9) {
                    System.out.println("Sebelum : ");
                    dll.print();
                    dll.sortAsc();
                    System.out.println("Sesudah : ");
                    dll.print();

                } else if (pil == 10) {
                    System.out.println("Sebelum : ");
                    dll.print();
                    dll.sortDsc();
                    System.out.println("Sesudah : ");
                    dll.print();

                }else if (pil == 11) {
                        System.out.println("Sebelum : ");
                        dll.print();
                        dll.sortAscnil();
                        System.out.println("Sesudah : ");
                        dll.print();
                }else if (pil == 13) {
                    System.out.println("Sebelum : ");
                    dll.print();
                    dll.sortDscnil();
                    System.out.println("Sesudah : ");
                    dll.print();


                }else if (pil == 13) {
                    System.exit(0);
                } else {
                    System.out.println("Pilihan tidak ada !");

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("Mau ngualngi Y/T");
            ch = sc.next().charAt(0);

        }while(ch == 'y' || ch == 'Y');
    }
}