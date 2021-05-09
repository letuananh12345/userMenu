import jdk.internal.dynalink.beans.StaticClass;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        int[] arr = new int[101];
        int size = 0;
        int choice;

        do {
            menu();
            System.out.println("nhập lựa chọn");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    size = inputSize();
                    inputArray(arr, size);
                    break;
                case 2:
                    displayArray(arr, size);
                    break;
                case 3:
                    int soChanMax = kTraMaxMang(arr, size);
                    System.out.println("số chẵn max trong mảng là : " + soChanMax);
                    break;
                case 4:
                    kTraSoChan(arr, size);
                    break;
                case 5:
                    int tinhTongSoChan= tinhTong(arr,size);
                    System.out.println("tổng các số chẵn là : "+ tinhTongSoChan);
                    break;
                case 8 :
                    int[] daoMang = dao(arr,size);
                    displayArray(daoMang, size);
                    break;
                case 9:
                    System.out.println("Danh sách số nguyên tố trong mảng : ");
                   kTraSNT(arr,size);
                   break;
                case  10:
                    int[] sapXepMangGiamDan =  sapXep(arr,size);
                    displayArray(sapXepMangGiamDan,size);
                    break;
                case 11:
                    System.exit(0);
                    break;
            }


        } while (choice>=11 || choice<=1 || choice==6 || choice == 7);


    }

    static void menu() {
        System.out.println("1.  Nhập mảng có kích thước N : <0<N<100>");
        System.out.println("2.  Hiển thị mảng vừa nhập : ");
        System.out.println("3.  Tìm số chẵn lớn nhất trong mảng :");
        System.out.println("4.  Liệt kê danh sách số chẵn : ");
        System.out.println("5.  Tính tổng các số chẵn : ");
        System.out.println("6.  Nhập vào giá trị và vị trí cần chèn vào mảng :");
        System.out.println("7.  Xóa tất cả phần tử có giá trị X khoi mảng : ");
        System.out.println("8.  Đảo ngược mảng ban đầu : ");
        System.out.println("9.  Hiện thị danh sách các số nguyên tố trong mảng :");
        System.out.println("10. Sắp xếp mảng theo thứ tự giảm dần : ");
        System.out.println("11. Thoát :");
    }

    static int inputSize() {
        int N;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng : ");
            N = sc.nextInt();
        } while (N <= 0 || N >= 100);
        return N;
    }

    static void inputArray(int[] arr, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập mảng gồm N phần tử :");
        for (int i = 0; i < N; i++) {
            System.out.print("phần tử thứ " + i + " là :");
            arr[i] = sc.nextInt();
        }
    }

    static void displayArray(int[] arr, int size) {
        System.out.print("mảng là : ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int kTraMaxMang(int[] arr, int N) {
        int max = arr[0];
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0 && arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void kTraSoChan(int[] arr, int N) {
        System.out.println("danh sách sốc chãn trong mảng là: ");
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println("số chẵn là : " + arr[i]);
            }
        }
    }

    static int tinhTong(int[] arr, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }
    static int[] dao(int[] arr, int N) {
        for (int i = 0, j = N - 1; i < j; i++, j--) {
            int x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }
        return arr;
    }
    static void kTraSNT(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    static int[] sapXep(int[] arr, int N) {
        for (int i =0; i<N-1;i++) {
            for (int j = i+1; j<N;j++) {
                if (arr[j] < arr[i]) {
                    int y = arr[i];
                    arr[i] = arr[j];
                    arr[j] = y;
                }
            }
        }
        return arr;
    }

}
