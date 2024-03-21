package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    public static Singer singer = new Singer();
    public static Song song = new Song(singer);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputData;
        while (true) {
            System.out.println("Mời bạn chọn 1 chức năng:");
            System.out.println("**********Music Management**********");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            inputData = Integer.parseInt(scanner.nextLine());
            switch (inputData) {
                case 1:
                    singerFunction(scanner);
                    break;
                case 2:
                    songFunction(scanner);
                    break;

                case 3:
                    searchFunction(scanner);
                case 4:
                    return;
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        }
    }

    public static void searchFunction(Scanner scanner) {
        while (true) {
            System.out.println("**********SEARCH-MANAGEMENT**********");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị 10 bài hát được sáng tác gần nhất");
            System.out.println("4.Thoát");
            byte searchOptions = Byte.parseByte(scanner.nextLine());
            switch (searchOptions) {
                case 1:
                    song.searchSongByArtistOrGenre();
                case 2:

                case 3:

                case 4:
                    return;
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        }

    }

    public static void songFunction(Scanner scanner) {
        while (true) {
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
                    song.showData();
                    break;
                case 3:
                    song.changeSongById();
                    break;
                case 4:
                    song.deleteSongById(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        }
    }

    public static void singerFunction(Scanner scanner) {
        while (true) {
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

                    return;
                default:
                    System.out.println("Chức năng không tồn tại");
            }
        }

    }
}