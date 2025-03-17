# CRM Sistemi: Müşteri Temsilcisi Yönlendirme ve Pazarlama Kampanyası Seçimi

## Proje Amacı

Bu projede, dinamik programlama kullanarak iki temel işlevi optimize eden bir CRM (Müşteri İlişkileri Yönetimi) sistemi geliştirilmiştir:

### 1. Müşteri Destek Temsilcisi Yönlendirme:
- Müşteri destek temsilcileri, belirli bir şehirdeki müşterilere en uygun şekilde atanmalıdır.
- Atamalar müşteri talepleri ve temsilcilerin uygunluğuna göre optimize edilmelidir.

### 2. Pazarlama Kampanyası Seçimi:
- Belirlenen bütçe kısıtları altında maksimum ROI (Yatırım Getirisi) elde edecek pazarlama kampanyaları belirlenmelidir.
- Her kampanyanın belirli bir maliyeti ve beklenen getirisi bulunmaktadır.

Bu iki fonksiyonun dinamik programlama teknikleriyle optimize edilmesi hedeflenmiştir.

## Kullanılan Algoritmalar

### 1. Müşteri Destek Temsilcisi Yönlendirme (Macar Algoritması)
- Bu problem, **atama problemi** (assignment problem) olarak bilinir ve çözümü için **Macar Algoritması** kullanılmıştır.
- Dinamik Programlama (DP) yaklaşımıyla her adımda minimum maliyetli temsilci-müşteri eşlemesi hesaplanmıştır.
- **Zaman Karmaşıklığı**: O(2^n * n^2)

### 2. Pazarlama Kampanyası Seçimi (0/1 Knapsack Problemi)
- Bu problem, **sırt çantası (knapsack) problemi** olarak bilinir ve dinamik programlama kullanılarak çözülmüştür.
- Her kampanya, belirli bir maliyet ve getirisiyle temsil edilerek bütçeyi aşmadan en iyi ROI elde edilmeye çalışılmıştır.
- **Zaman Karmaşıklığı**: O(n * B) (n: kampanya sayısı, B: bütçe limiti)

## Dinamik Programlamanın Seçilme Nedeni

### 1. Karmaşık Problemleri Daha Verimli Çözme:
- Hem Macar Algoritması hem de Knapsack problemi, alt problemleri tekrar kullanarak optimal çözüm bulur.
- Brute Force (kaba kuvvet) yaklaşımından kaçınılarak zaman karmaşıklığı düşürülmüştür.

### 2. Karar Ağacı İşlemleri İçin Uygundur:
- Müşteri ve temsilcileri eşleştirmek gibi bağımsız karar noktalarını optimize eder.
- Kampanya seçimi için en iyi kombinasyonları hesaplar.

### 3. Bellek Optimizasyonu ile Daha Hızlı Çözüm Sunar:
- Tekrarlayan hesaplamalar bir diziye kaydedilerek hesaplama maliyetleri düşürülmüştür.
- **Memoization** (hafıza alma) ve **tablolama** teknikleri kullanılmıştır.

## Projenin Çalışma Mantığı

### 1. Maliyet Matrisi (Müşteri Temsilcisi Yönlendirme)
- Temsilci-müşteri eşleşmesini yapar.
- Minimum maliyetli eşleşme bulunur.

### 2. 0/1 Knapsack Problemi (Pazarlama Kampanyası Seçimi)
- Kampanya maliyetleri ve getiri hesaplanır.
- Bütçe dahilinde en iyi kombinasyon belirlenir.
