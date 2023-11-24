import java.util.ArrayList;

public class Restaurant{
    private int id;
    private String nama;
    private String alamat;
    private ArrayList<Menu> makanan;
    private ArrayList<Menu> minuman;
    
    public Restaurant(){
        //default constructor
        this.makanan = new ArrayList<>();
        this.minuman = new ArrayList<>();
    }

    public Restaurant(int id, String nama, String alamat){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.makanan = new ArrayList<>();
        this.minuman = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<Menu> getMakanan() {
        return makanan;
    }

    public void setMakanan(ArrayList<Menu> makanan) {
        this.makanan = makanan;
    }

    public void addMakanan(Menu makanan) {
        this.makanan.add(makanan);
    }

    public ArrayList<Menu> getMinuman() {
        return minuman;
    }

    public void setMinuman(ArrayList<Menu> minuman) {
        this.minuman = minuman;
    }

    public void addMinuman(Menu minuman) {
        this.minuman.add(minuman);
    }
}