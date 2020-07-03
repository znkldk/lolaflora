Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs

Başarılı Login
------
* "popUpkapa" elementine tıkla
* "singInIcon" elementi üzerinde dur
* "singInBtn" elementine tıkla
* "emailAdressBar" elementine "znkldk@gmail.com" degerini gir
* "passwordBar" elementine "123123123" degerini gir
* "singInPageSingInBtn" elementine tıkla
* "singOutBtn" elementi sayfada yoksa "Giriş yapılamadı" hata mesajını göster

Başarısız Login
------
* "popUpkapa" elementine tıkla
* "singInIcon" elementi üzerinde dur
* "singInBtn" elementine tıkla
* "emailAdressBar" elementine "znkldk@gmail.com" degerini gir
* "passwordBar" elementine "yanlışşifre" degerini gir
* "singInPageSingInBtn" elementine tıkla
* "yanlisLoginHataMesajı" elementi sayfada yoksa "Hata Mesajı görülemedi" hata mesajını göster