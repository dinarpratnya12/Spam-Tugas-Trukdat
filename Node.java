public class Node {
    int nilai;
    int nim;
    String nama;
    String alamat;
    Node prev , next ;
    Node(Node prev , int nilai ,int nim, String nama,String alamat , Node next){
        this.prev = prev;
        this.nilai = nilai;
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.next = next;


    }
}