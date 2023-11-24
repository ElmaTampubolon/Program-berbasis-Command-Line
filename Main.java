import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, password;
        int pil, id, index, kuantitas, countRestaurant = 0;
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        char loop;

        do{
            System.out.println("===Menu Utama===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print(">> ");
            pil = Integer.parseInt(input.nextLine());

            System.out.println();
            switch(pil){
                case 1:{
                    System.out.print("Username : ");
                    username = input.nextLine();

                    System.out.print("Password : ");
                    password = input.nextLine();

                    if(username.equals("admin") && password.equals("admin")){
                        do{
                            System.out.println("\n===Menu Admin===");
                            System.out.println("1. Lihat Restaurant");
                            System.out.println("2. Tambah Restaurant");
                            System.out.println("3. Hapus Restaurant");
                            System.out.println("4. Kembali ke login");
                            System.out.print(">> ");
                            pil = Integer.parseInt(input.nextLine());

                            System.out.print("\n");
                            switch(pil){
                                case 1:{
                                    if(restaurants.size() > 0){
                                        System.out.print("Data Restaurant :");
                                        for(Restaurant restaurant : restaurants){
                                            System.out.println("\nID      : " + restaurant.getId());
                                            System.out.println("Nama    : " + restaurant.getNama());
                                            System.out.println("Alamat  : " + restaurant.getAlamat());
                                            if(restaurant.getMakanan().size() > 0){
                                                System.out.println("Menu Makanan :");
                                                for(int i=0; i < restaurant.getMakanan().size(); i++){
                                                    System.out.println((i+1) + ". " + restaurant.getMakanan().get(i).getNama() + " ( " + restaurant.getMakanan().get(i).getHarga() + " )");
                                                }
                                            }else{
                                                System.out.println("[!] Tidak Ada Menu Makanan");
                                            }

                                            if(restaurant.getMinuman().size() > 0){
                                                System.out.println("Menu Minuman :");
                                                for(int i=0; i < restaurant.getMinuman().size(); i++){
                                                    System.out.println((i+1) + ". " + restaurant.getMinuman().get(i).getNama() + " ( " + restaurant.getMinuman().get(i).getHarga() + " )");
                                                }
                                            }else{
                                                System.out.println("[!] Tidak Ada Menu Minuman");
                                            }
                                        }
                                    }else{
                                        System.out.println("Data Restaurant Masih Kosong!");
                                    }

                                    break;
                                }

                                case 2:{
                                    countRestaurant += 1;
                                    
                                    Restaurant restoran = new Restaurant();

                                    System.out.print("Masukkan Nama Restaurant : ");
                                    restoran.setNama(input.nextLine());

                                    System.out.print("\nMasukkan Alamat Restaurant : ");
                                    restoran.setAlamat(input.nextLine());

                                    while(true) {
                                        System.out.print("\nApakah Ingin Menambahkan Menu Makanan [Y/N] : ");
                                        loop = input.nextLine().toUpperCase().charAt(0);

                                        if(loop == 'Y'){
                                            Menu makanan = new Menu();
                                            
                                            System.out.print("\nMasukkan Nama Makanan : ");
                                            makanan.setNama(input.nextLine());

                                            System.out.print("\nMasukkan Harga Makanan : ");
                                            makanan.setHarga(Long.valueOf(input.nextLine()));

                                            restoran.addMakanan(makanan);
                                        }else if(loop == 'N'){
                                            break;
                                        }
                                    }

                                    while(true){
                                        System.out.print("\nApakah Ingin Menambahkan Menu Minuman [Y/N] : ");
                                        loop = input.nextLine().toUpperCase().charAt(0);

                                        if(loop == 'Y'){
                                            Menu minuman = new Menu();
                                            
                                            System.out.print("\nMasukkan Nama Minuman : ");
                                            minuman.setNama(input.nextLine());

                                            System.out.print("\nMasukkan Harga Minuman : ");
                                            minuman.setHarga(Long.valueOf(input.nextLine()));

                                            restoran.addMinuman(minuman);
                                        }else if(loop == 'N'){
                                            break;
                                        }
                                    }

                                    restoran.setId(countRestaurant);

                                    restaurants.add(restoran);
                                    System.out.println("\nData Restaurant Berhasil ditambahkan!");

                                    break;
                                }

                                case 3:{
                                    System.out.print("Masukkan Id Restaurant yang ingin dihapus : ");
                                    id = Integer.parseInt(input.nextLine());

                                    index = -1;
                                    for(int i=0; i<restaurants.size(); i++){
                                        if(restaurants.get(i).getId() == id){
                                            index = i;
                                            break;
                                        }
                                    }

                                    if(index != -1){
                                        restaurants.remove(index);
                                        System.out.println("Berhasil Menghapus Data Restraunt dengan ID " + id);
                                    }else{
                                        System.out.println("Gagal Menghapus Data Restaurant dengan ID " + id + ". ID Tidak ditemukan!");
                                    }

                                    break;
                                }

                                case 4:{
                                    System.out.println("Kembali ke login ...");

                                    break;
                                }

                                default:{
                                    System.out.println("Pilihan Menu Admin Tidak Valid!");

                                    break;
                                }
                            }

                            if(pil != 4){
                                System.out.print("\n");
                            }
                        }while(pil != 4);
                    }else if(username.equals("user") && password.equals("user")){
                        do{
                            System.out.println("\n===Menu User===");
                            System.out.println("1. Lihat Restaurant");
                            System.out.println("2. Buat Pesanan");
                            System.out.println("3. Lihat Pesanan");
                            System.out.println("4. Kembali ke login");
                            System.out.print(">> ");
                            pil = Integer.parseInt(input.nextLine());

                            System.out.print("\n");
                            switch(pil){
                                case 1:{
                                    if(restaurants.size() > 0){
                                        System.out.print("Data Restaurant :");
                                        for(Restaurant restaurant : restaurants){
                                            System.out.println("\nID      : " + restaurant.getId());
                                            System.out.println("Nama    : " + restaurant.getNama());
                                            System.out.println("Alamat  : " + restaurant.getAlamat());
                                            if(restaurant.getMakanan().size() > 0){
                                                System.out.println("Menu Makanan :");
                                                for(int i=0; i < restaurant.getMakanan().size(); i++){
                                                    System.out.println((i+1) + ". " + restaurant.getMakanan().get(i).getNama() + " ( " + restaurant.getMakanan().get(i).getHarga() + " )");
                                                }
                                            }else{
                                                System.out.println("[!] Tidak Ada Menu Makanan");
                                            }

                                            if(restaurant.getMakanan().size() > 0){
                                                System.out.println("Menu Minuman :");
                                                for(int i=0; i < restaurant.getMinuman().size(); i++){
                                                    System.out.println((i+1) + ". " + restaurant.getMinuman().get(i).getNama() + " ( " + restaurant.getMinuman().get(i).getHarga() + " )");
                                                }
                                            }else{
                                                System.out.println("[!] Tidak Ada Menu Minuman");
                                            }
                                        }
                                    }else{
                                        System.out.println("Data Restaurant Masih Kosong!");
                                    }

                                    break;
                                }

                                case 2:{
                                    if(restaurants.size() > 0){
                                        System.out.print("Masukkan ID Restaurant : ");
                                        id = Integer.parseInt(input.nextLine());

                                        index = -1;
                                        for(int i=0; i<restaurants.size(); i++){
                                            if(restaurants.get(i).getId() == id){
                                                index = i;
                                                break;
                                            }
                                        }

                                        if(index != -1){
                                            ArrayList<Menu> menu;
                                            long total = 0;
                                            Order order = new Order();
                                            order.setIdRestaurant(restaurants.get(index).getId());

                                            if(restaurants.get(index).getMakanan().size() > 0){
                                                System.out.println("Menu Makanan :");
                                                menu = restaurants.get(index).getMakanan();
                                                for(int i=0; i<menu.size(); i++){
                                                    System.out.println((i+1) + ". " + menu.get(i).getNama() + " ( " + menu.get(i).getHarga() + " )");
                                                }
                                                while(true){
                                                    System.out.print("Ingin Memesan Menu Makanan [Y/N] : ");
                                                    loop = input.nextLine().toUpperCase().charAt(0);

                                                    if(loop == 'Y'){
                                                        System.out.print("Masukkan Nomor Menu Makanan : ");
                                                        id = Integer.parseInt(input.nextLine());

                                                        if(id >= 1 && id <= menu.size()){
                                                            id -= 1;

                                                            order.addMenuMakanan(menu.get(id));

                                                            while(true){
                                                                System.out.print("Masukkan Kuantitas Pembelian : ");
                                                                kuantitas = Integer.parseInt(input.nextLine());

                                                                if(kuantitas <= 0){
                                                                    System.out.println("[!] Kuantitas Pembelian Tidak Boleh Kurang atau Sama Dengan 0!");
                                                                }else{
                                                                    break;
                                                                }
                                                            }
                                                            order.addQtyMenuMakanan(kuantitas);
                                                            total += menu.get(id).getHarga() * order.getQtyMenuMakanan().get(order.getQtyMenuMakanan().size()-1);
                                                            System.out.println("Berhasil Menambahkan Menu!");
                                                        }else{
                                                            System.out.println("Nomor Menu Tidak Valid!");
                                                        }
                                                    }else if(loop == 'N'){
                                                        break;
                                                    }
                                                }
                                            }

                                            if(restaurants.get(index).getMinuman().size() > 0){
                                                System.out.println("Menu Minuman :");
                                                menu = restaurants.get(index).getMinuman();
                                                for(int i=0; i<menu.size(); i++){
                                                    System.out.println((i+1) + ". " + menu.get(i).getNama() + " ( " + menu.get(i).getHarga() + " )");
                                                }
                                                while(true){
                                                    System.out.print("Ingin Memesan Menu Minuman [Y/N] : ");
                                                    loop = input.nextLine().toUpperCase().charAt(0);

                                                    if(loop == 'Y'){
                                                        System.out.print("Masukkan Nomor Menu Minuman : ");
                                                        id = Integer.parseInt(input.nextLine());

                                                        if(id >= 1 && id <= menu.size()){
                                                            id -= 1;

                                                            order.addMenuMinuman(menu.get(id));

                                                            while(true){
                                                                System.out.print("Masukkan Kuantitas Pembelian : ");
                                                                kuantitas = Integer.parseInt(input.nextLine());

                                                                if(kuantitas <= 0){
                                                                    System.out.println("[!] Kuantitas Pembelian Tidak Boleh Kurang atau Sama Dengan 0!");
                                                                }else{
                                                                    break;
                                                                }
                                                            }
                                                            order.addQtyMenuMinuman(kuantitas);
                                                            total += menu.get(id).getHarga() * order.getQtyMenuMinuman().get(order.getQtyMenuMinuman().size()-1);
                                                            System.out.println("Berhasil Menambahkan Menu!");
                                                        }else{
                                                            System.out.println("Nomor Menu Tidak Valid!");
                                                        }
                                                    }else if(loop == 'N'){
                                                        break;
                                                    }
                                                }
                                            }

                                            while(true){
                                                System.out.print("Masukkan Jarak Lokasi Antar (km) : ");
                                                order.setJarak(Float.valueOf(input.nextLine()));

                                                if(order.getJarak() <= 0){
                                                    System.out.println("[!] Jarak Lokasi Antar Tidak Boleh Kurang atau Sama Dengan 0!");        
                                                }else{
                                                    break;
                                                }
                                            }

                                            order.setTotal(total);

                                            System.out.println("Pesanan telah ditambahkan!");
                                            orders.add(order);
                                        }else{
                                            System.out.println("Gagal Membuat Pesanan. Restaurant dengan ID " + id + " Tidak Ditemukan!");
                                        }
                                    }else{
                                        System.out.println("Tidak Dapat Membuat Pesanan. Data Restaurant Masih Kosong!");
                                    }

                                    break;
                                }

                                case 3:{
                                    if(orders.size() > 0){
                                        System.out.print("Data Order :");
                                        for(Order order : orders){
                                            System.out.println("\nID Restaurant : " + order.getIdRestaurant());
                                            System.out.println("Jarak Lokasi Antar : " + order.getJarak() + " km");
                                            if(order.getMenuMakanan().size() > 0){
                                                System.out.println("Menu Makanan :");
                                                for(int i=0; i < order.getMenuMakanan().size(); i++){
                                                    System.out.println((i+1) + ". " + order.getMenuMakanan().get(i).getNama() + " ( " + order.getMenuMakanan().get(i).getHarga() + " ) x " + order.getQtyMenuMakanan().get(i));
                                                }
                                            }

                                            if(order.getMenuMinuman().size() > 0){
                                                System.out.println("Menu Minuman :");
                                                for(int i=0; i < order.getMenuMinuman().size(); i++){
                                                    System.out.println((i+1) + ". " + order.getMenuMinuman().get(i).getNama() + " ( " + order.getMenuMinuman().get(i).getHarga() + " ) x " + order.getQtyMenuMinuman().get(i));
                                                }
                                            }

                                            System.out.println("Total Order : " + order.getTotal());
                                        }
                                    }else{
                                        System.out.println("Data Order Masih Kosong!");
                                    }

                                    break;
                                }

                                case 4:{
                                    System.out.println("Kembali ke login ...");

                                    break;
                                }

                                default:{
                                    System.out.println("Pilihan Menu Admin Tidak Valid!");

                                    break;
                                }
                            }

                            if(pil != 4){
                                System.out.print("\n");
                            }
                        }while(pil != 4);
                    }else{
                        System.out.println("Username atau Password Salah!");
                    }

                    break;
                }

                case 2:{
                    System.out.println("Keluar dari program ...");
                    
                    break;
                }

                default:{
                    System.out.println("Pilihan Menu Utama Tidak Valid!");

                    break;
                }
            }

            if(pil != 2){
                System.out.println();
            }
        }while(pil != 2);

        input.close();
    }
}
