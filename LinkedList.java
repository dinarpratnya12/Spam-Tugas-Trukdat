public class LinkedList {
    Node head, tail;
    int size;

    LinkedList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int nilai, int nim, String nama, String alamat) {

        if (isEmpty())
            tail = head = new Node(null, nilai, nim, nama, alamat, null);
        else {
            Node newNode = new Node(null, nilai, nim, nama, alamat, head);
            head.prev = newNode;

            head = newNode;
        }

        size++;

    }

    public void addLast(int nilai, int nim, String nama, String alamat) {
        if (isEmpty())
            addFirst(nilai, nim, nama, alamat);
        else {
            Node newNode = new Node(tail, nilai, nim, nama, alamat, null);
            tail.next = newNode;
            tail = tail.next;
            size++;
        }
    }

    public void add(int nilai, int nim, String nama, String alamat, int index) throws Exception {
        if (isEmpty()) addFirst(nilai, nim, nama, alamat);
        if (index < 0 || index > size) throw new Exception("Nilai indeks di luar batas");
        else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            if (current.prev == null) {
                Node newNode = new Node(null, nilai, nim, nama, alamat, current);
                current.prev = newNode;
                head = newNode;
            } else {
                Node newNode = new Node(current.prev, nilai, nim, nama, alamat, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }


    public void removeFirst() {
        if (isEmpty()) try {
            throw new Exception("Linked List masih Kosong , tidak dapat dihapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else if (size == 1) {
            removeFirst();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) try {
            throw new Exception("Linked List masih Kosong , tidak dapat dihapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        tmp.prev = null;
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) try {
            throw new Exception("Linked List masih Kosong , tidak dapat dihapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;

        }
    }

    public Node getFirst() {
        if (isEmpty()) try {
            throw new Exception("Linked List Kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return head;

    }

    public Node getLast() {
        if (isEmpty()) try {
            throw new Exception("Linked List Kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tail;
    }

    public Node get(int index) {
        if (isEmpty() || index >= size) try {
            throw new Exception("Index diluar batas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public Node getKey(String key) {
        if (isEmpty()) try {
            throw new Exception("Linked List Kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node tmp = head;

        for (int i = 0; i < size; i++) {
            if (tmp.nama.equalsIgnoreCase(key)) {
                return tmp;
            }
            tmp = tmp.next;

        }
        return null;
    }

    public int getIndex(Node tmp2) {
        if (isEmpty()) try {
            throw new Exception("Index diluar batas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node tmp = head;
        for (int i = 0; i < size; i++) {

            if (tmp.nama == tmp2.nama) {
                return i;
            }
            tmp = tmp.next;
        }
        return 0;
    }


    public void banding() {
        if (isEmpty()) try {
            throw new Exception("Linked list kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Node cur = head;

        if (cur.nilai < cur.next.nilai) {
            Node tmp = cur;
            cur = cur.next;
            cur.prev = tmp.prev;
            tmp.next = cur.next;
            cur.next = tmp;
            cur.next.prev = cur;
            head = cur;


        }
    }

    public void sortAsc() {
        if (isEmpty()) try {
            throw new Exception("Linked list kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < size; i++) {
            Node cur = head;
            while (cur.next != null) {
                if (cur.nim > cur.next.nim) {
                    if (cur == head) {

                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        head = cur;
                    } else if (cur.next == tail) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;
                        tail = cur.next;
                    } else {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;

                    }
                }

                cur = cur.next;


            }


        }


    }

    public void sortAscnil() {
        if (isEmpty()) try {
            throw new Exception("Linked list kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < size; i++) {
            Node cur = head;
            while (cur.next != null) {
                if (cur.nilai > cur.next.nilai) {
                    if (cur == head) {

                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        head = cur;
                    } else if (cur.next == tail) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;
                        tail = cur.next;
                    } else {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;

                    }
                }

                cur = cur.next;


            }


        }


    }

    public void sortDsc() {
        if (isEmpty()) try {
            throw new Exception("Linked list kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < size; i++) {
            Node cur = head;
            while (cur.next != null) {

                if (cur.nim < cur.next.nim) {
                    if (cur == head) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        head = cur;

                    } else if (cur.next == tail) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev.next;
                        cur.prev.next = cur;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        tail = cur.next;
                        tail.next = null;
                    } else {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;

                    }
                }

                cur = cur.next;

            }
        }


    }

    public void sortDscnil() {
        if (isEmpty()) try {
            throw new Exception("Linked list kosong");
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < size; i++) {
            Node cur = head;
            while (cur.next != null) {

                if (cur.nilai < cur.next.nilai) {
                    if (cur == head) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        head = cur;

                    } else if (cur.next == tail) {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev.next;
                        cur.prev.next = cur;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        tail = cur.next;
                        tail.next = null;
                    } else {
                        Node tmp = cur;
                        cur = cur.next;
                        cur.prev = tmp.prev;
                        tmp.next = cur.next;
                        tmp.next.prev = tmp;
                        cur.next = tmp;
                        cur.next.prev = cur;
                        cur.prev.next = cur;

                    }
                }

                cur = cur.next;

            }
        }


    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            int i = 1;
            while (tmp != null) {
                System.out.println(tmp.nama + "\t" + tmp.nilai + "\t" + tmp.alamat + "\t" + tmp.nim);
                tmp = tmp.next;
                i++;
            }
            System.out.println("Berhasil diisi");
        } else {
            System.out.println("Kosong !");
        }
    }

}
