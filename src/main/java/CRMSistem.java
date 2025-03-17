import java.util.Arrays;

public class CRMSistem {

    // ----------------- 1. Müşteri Destek Temsilcisi Yönlendirme (Macar Algoritması) ----------------- //

    public static int minMaliyetAtama(int[][] maliyet) {
        int n = maliyet.length;
        int[] dp = new int[1 << n]; // 2^n boyutlu Dinamik Programlama (DP) dizisi
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int maske = 0; maske < (1 << n); maske++) {
            int atananTemsilciSayisi = Integer.bitCount(maske); // Atanan temsilci sayısını hesapla
            if (atananTemsilciSayisi >= n) continue;

            for (int j = 0; j < n; j++) {
                if ((maske & (1 << j)) == 0) { // Eğer j temsilcisi atanmadıysa
                    int yeniMaske = maske | (1 << j);
                    dp[yeniMaske] = Math.min(dp[yeniMaske], dp[maske] + maliyet[atananTemsilciSayisi][j]);
                }
            }
        }
        return dp[(1 << n) - 1]; // Tüm temsilciler atandıysa minimum maliyet
    }

    // ----------------- 2. Pazarlama Kampanyası Seçimi (0/1 Knapsack Problemi) ----------------- //

    public static int maxYatirimGetirisi(int[] maliyet, int[] getiri, int butce) {
        int n = maliyet.length;
        int[][] dp = new int[n + 1][butce + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= butce; j++) {
                if (maliyet[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - maliyet[i - 1]] + getiri[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][butce]; // En yüksek yatırım getirisi (ROI)
    }

    public static void main(String[] args) {
        // Test verileri

        // 1. Müşteri Temsilcisi Yönlendirme
        int[][] maliyetMatrisi = {
                {9, 2, 7, 8},
                {6, 4, 3, 7},
                {5, 8, 1, 8},
                {7, 6, 9, 4}
        };
        System.out.println("Minimum Atama Maliyeti: " + minMaliyetAtama(maliyetMatrisi));

        // 2. Pazarlama Kampanyası Seçimi
        int[] maliyet = {10, 20, 30, 40}; // Kampanya maliyetleri
        int[] getiri = {60, 100, 120, 140}; // Kampanya getirileri
        int butce = 50;
        System.out.println("Maksimum Yatırım Getirisi: " + maxYatirimGetirisi(maliyet, getiri, butce));
    }
}
