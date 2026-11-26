# 👋 Akif Gürkan | Yazılım Test Uzmanı  

Merhaba! Ben **Akif Gürkan**, yazılım test uzmanı olarak manuel ve otomasyon test süreçlerinde deneyimliyim.  
Kaliteli yazılımın, iyi bir test sürecinden geçtiğine inanıyorum.  
Bu GitHub sayfamda projelerimi, test süreçlerimi ve öğrendiğim teknolojileri paylaşıyorum.

---

## 🚀 Hakkımda

- 🎯 **Freelance** olarak yazılım test projelerinde çalışıyorum.  
- 📚 **ISTQB Foundation Level** sertifikasına sahibim.  
- 🔍 **Test Alanlarım:**  
  - Web Test Otomasyonu  
  - Mobil Test Otomasyonu  
  - API Testleri  
  - Manuel Testler  

---

## 🔧 Teknolojiler ve Araçlar

- **Programlama Dilleri:**  
  - Core Java  
  - SQL (Temel Seviye)  

- **Test Araçları ve Çerçeveler:**  
  - Selenium  
  - Cucumber  
  - TestNG  
  - Appium  
  - Postman  

- **Sürüm Kontrol ve Yönetim Araçları:**  
  - Git  
  - Jira  
  - Asana
  - Jenkins  

---

## 📂 Projelerimden Bazıları:  

1. **[Abone Sepeti: Web Test Otomasyonu]**  
   - 📄 Açıklama: Bu proje, Abone Sepeti sitesinin fonksiyonel testlerini gerçekleştirmek amacıyla oluşturulmuştur.  
   - 🚀 Teknolojiler: Selenium, Java, Cucumber  
 
2. **[Abone Sepeti: Mobil Uygulama Testi]**  
   - 📄 Açıklama: Bir mobil uygulamanın kullanıcı dostu ve hatasız çalışmasını sağlamak için yapılmış test çalışması.  
   - 🚀 Teknolojiler: Manuel ve Appium ile Mobil tesler yapıldı. 
 
   3. **[Abone Sepeti-İşCep Mobil: Mobil Uygulama Testi]**  
   - 📄 Açıklama: İş bankası mobil uygulamasına entegre edilen Abonesepeti uygulamasının kullanıcı dostu ve hatasız çalışmasını sağlamak için yapılmış test manuel çalışması.  
   - 🚀 Teknolojiler: Asana  
   
---

## 🧪 Portföy Sitesi UI Test Otomasyonu

[![Portföy UI Testleri](https://github.com/akifgurkan/akifgurkan.github.io/actions/workflows/portfolio-ui-tests.yml/badge.svg?branch=main)](https://github.com/akifgurkan/akifgurkan.github.io/actions/workflows/portfolio-ui-tests.yml)

Kişisel portföy sitesinin temel kullanıcı akışlarını doğrulayan beş Selenium smoke testi. Test projesi [`portfolio-ui-tests`](./portfolio-ui-tests) dizininde ve Page Object Model yapısını kullanıyor.

**Teknolojiler:** Java 21, Selenium, TestNG, Maven, Allure Report ve GitHub Actions.

### Test kapsamı

1. Sayfa başlığı ve profil ismi
2. Profil fotoğrafının görünürlüğü ve yüklenmesi
3. Türkçe ve İngilizce dil geçişleri
4. Açık ve koyu tema geçişleri
5. İletişim formunda isim ve e-posta alanlarının doğrulanması

Form kontrolleri alan doğrulamasıyla sınırlıdır.

### Yerelde çalıştırma

Java 21, Maven, Python 3 ve Google Chrome gerekir. Repo kökünden iki PowerShell terminali aç.

**Birinci terminalde** yerel web sunucusunu başlat:

```powershell
python -m http.server 8000 --bind 127.0.0.1
```

**İkinci terminalde** testleri çalıştır:

```powershell
cd portfolio-ui-tests
mvn clean test "-DbaseUrl=http://127.0.0.1:8000/" "-Dbrowser=chrome" "-Dheadless=true"
```

### Allure raporu ve CI

Testlerden sonra ikinci terminalde `mvn allure:serve` ile raporu tarayıcıda açabilir veya `mvn allure:report` ile HTML raporu üretebilirsin. Rapor, test adımlarını, ortam bilgilerini ve başarısız testlerin ekran görüntülerini içerir.

GitHub Actions, `main` dalına açılan pull request’lerde ve `main` veya `feature/portfolio-ci-tests` dallarına yapılan push’larda checkout edilen siteyi Chrome headless ile test eder. Allure HTML raporu ve mevcut test çıktıları, koşunun **Artifacts** bölümünde 7 gün saklanır.

---


## 📬 İletişim  

- 🌐 **Kişisel Web Sitesi:** [akifgurkan.github.io](https://akifgurkan.github.io)  
- 📧 **E-posta:** [akifgurkan15@gmail.com](mailto:akifgurkan15@gmail.com
)  
- 💼 **LinkedIn:** [https://www.linkedin.com/in/akifgurkan/](https://www.linkedin.com/in/akifgurkan/)   
- 📸 **Instagram:** [qatester1532](https://www.instagram.com/qatester1532/)  


---

> 💡 **Not:** Bu sayfa sürekli olarak güncellenmektedir. Yeni projelerimi ve deneyimlerimi eklemeye devam edeceğim!
> Ziyaretiniz için Teşekkürler :)
- © 2026 Akif Gürkan. All rights reserved.
