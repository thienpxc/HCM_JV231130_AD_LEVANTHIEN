package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Singer singer = new Singer();
        Song song = new Song(singer);
        while (true) {
            System.out.println("**********Music Management**********");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("Mời bạn chọn chức năng:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:

                    boolean singerFunction = true;
                    while (singerFunction) {
                        System.out.println("**********Singer Management**********");
                        System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
                        System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
                        System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
                        System.out.println("4.Xóa ca sĩ theo mã id");
                        System.out.println("5. Thoát");
                        byte choiceSinger = Byte.parseByte(scanner.nextLine());
                        switch (choiceSinger) {
                            case 1:
                                singer.addData(scanner);
                                break;
                            case 2:
                                singer.showData();
                                break;
                            case 3:
                                singer.updateSinger(scanner);
                                break;
                            case 4:
                                singer.deleteSinger(scanner);
                                break;
                            case 5:
                                singerFunction = false;
                                break;
                            default:
                                System.out.println("Chức năng không tồn tại");
                        }
                    }
                    break;
                case 2:

                    boolean songFunction = true;
                    while (songFunction) {
                        System.out.println("**********Song Management**********");
                        System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
                        System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
                        System.out.println("3.Thay đổi thông tin bài hát theo mã id");
                        System.out.println("4.Xóa bài hát theo mã id");
                        System.out.println("5.Thoát");

                        byte choiceSong = Byte.parseByte(scanner.nextLine());
                        switch (choiceSong) {
                            case 1:
                                song.addSong(scanner);
                                break;
                            case 2:
                                song.showSong();
                                break;
                            case 3:
                                song.changeSongById();
                                break;
                            case 4:
                                song.deleteSongById(scanner);
                                break;
                            case 5:
                                songFunction = false;
                                break;
                            default:
                                System.out.println("Chức năng không tồn tại");
                        }
                    }
                    break;
                case 3:
                    boolean searchFunction = true;
                    while (searchFunction){
                        System.out.println("**********SEARCH-MANAGEMENT**********");
                        System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
                        System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
                        System.out.println("3.Hiển thị 10 bài hát được sáng tác gần nhất");
                        System.out.println("4.Thoát");
                        byte searchOptions = Byte.parseByte(scanner.nextLine());
                        switch (searchOptions){
                            case 1:


                            case 2:

                            case 3:

                            case 4:
                                searchFunction = false;
                            default:
                                System.out.println("Chức năng không tồn tại");
                        }
                    }

                    break;
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        }
    }
}