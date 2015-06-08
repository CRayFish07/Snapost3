# Snapost3
### 【之前那个源不要了。。。我们开一新的
一共有这么多代码【全部加起来大概7600行左右
```
.
├── build
│   └── classes
│       ├── Database
│       │   ├── Create.class
│       │   ├── Delete.class
│       │   ├── Drop.class
│       │   ├── Insert.class
│       │   ├── Select.class
│       │   └── Update.class
│       ├── ImageProcess
│       │   └── Image.class
│       └── Servlet
│           ├── SnapostAddFriend.class
│           ├── Snapostblack.class
│           ├── SnapostCloseUser.class
│           ├── SnapostdeleteAlbum.class
│           ├── SnapostDeleteFriend.class
│           ├── SnapostdeletePhoto.class
│           ├── SnapostLogin.class
│           ├── SnapostnewAlbum.class
│           ├── SnapostnewRegister.class
│           ├── SnapostnewShare.class
│           ├── SnapostnewUpload.class
│           ├── SnapostPassword.class
│           ├── SnapostpicProcess.class
│           ├── SnapostRegister.class
│           ├── SnapostsaveNewPic.class
│           ├── SnapostSetting.class
│           ├── SnapostWAnnounce.class
│           └── SnapostWarnUser.class
├── jars
│   ├── commons-fileupload-1.3.1.jar
│   ├── commons-io-2.4.jar
│   ├── spring-web.jar
│   ├── spring-webmvc.jar
│   └── sqljdbc4.jar
├── src
│   ├── Database
│   │   ├── Create.java
│   │   ├── Delete.java
│   │   ├── Drop.java
│   │   ├── Insert.java
│   │   ├── Select.java
│   │   └── Update.java
│   ├── ImageProcess
│   │   └── Image.java
│   └── Servlet
│       ├── SnapostAddFriend.java
│       ├── Snapostblack.java
│       ├── SnapostCloseUser.java
│       ├── SnapostdeleteAlbum.java
│       ├── SnapostDeleteFriend.java
│       ├── SnapostdeletePhoto.java
│       ├── SnapostLogin.java
│       ├── SnapostnewAlbum.java
│       ├── SnapostnewRegister.java
│       ├── SnapostnewShare.java
│       ├── SnapostnewUpload.java
│       ├── SnapostPassword.java
│       ├── SnapostpicProcess.java
│       ├── SnapostRegister.java
│       ├── SnapostsaveNewPic.java
│       ├── SnapostSetting.java
│       ├── SnapostWAnnounce.java
│       └── SnapostWarnUser.java
└── WebContent
    ├── ad_announce.jsp
    ├── ad_check_upic.jsp
    ├── ad_check_user.jsp
    ├── ad_history_detail.jsp
    ├── ad_history.jsp
    ├── ad_mainpage.jsp
    ├── ad_title5.png
    ├── album_check.jsp
    ├── albumfalse.jsp
    ├── bootstrap.min.js
    ├── docs.min.js
    ├── false1.jsp
    ├── false.jsp
    ├── friend_check.jsp
    ├── help.jsp
    ├── index2.html
    ├── index.html
    ├── jquery.min.js
    ├── login_in.jsp
    ├── mail_box.jsp
    ├── mail_detail.jsp
    ├── main_page2.jsp
    ├── main_page.jsp
    ├── META-INF
    │   └── MANIFEST.MF
    ├── MyJsp.jsp
    ├── pic_list.jsp
    ├── Register.jsp
    ├── setting.jsp
    ├── setting_password.jsp
    ├── single_pic.jsp
    ├── sizefalse.jsp
    ├── title.png
    └── WEB-INF
        ├── lib
        │   └── commons-fileupload-1.3.1.jar
        └── web.xml
```
#### 上面是所有的文件，大家需要提交的部分分割如下：
- 文夕：src/Database、src/ImageProcess下的所有文件
- 珍珠：
```
    ├── ad_announce.jsp
    ├── ad_check_upic.jsp
    ├── ad_check_user.jsp
    ├── ad_history_detail.jsp
    ├── ad_history.jsp
    ├── ad_mainpage.jsp
    ├── ad_title5.png
    ├── album_check.jsp
    ├── albumfalse.jsp
    ├── bootstrap.min.js
    ├── docs.min.js
    ├── false1.jsp
    ├── false.jsp
    ├── friend_check.jsp
    ├── help.jsp
    ├── index2.html
    ├── index.html
    ├── jquery.min.js
    ├── login_in.jsp
```
- 高高：
```
    ├── mail_box.jsp
    ├── mail_detail.jsp
    ├── main_page2.jsp
    ├── main_page.jsp
    ├── META-INF
    │   └── MANIFEST.MF
    ├── MyJsp.jsp
    ├── pic_list.jsp
    ├── Register.jsp
    ├── setting.jsp
    ├── setting_password.jsp
    ├── single_pic.jsp
    ├── sizefalse.jsp
    ├── title.png
    └── WEB-INF
        ├── lib
        │   └── commons-fileupload-1.3.1.jar
        └── web.xml
```
- 邵菲
```
│   └── Servlet
│       ├── SnapostAddFriend.java
│       ├── Snapostblack.java
│       ├── SnapostCloseUser.java
│       ├── SnapostdeleteAlbum.java
│       ├── SnapostDeleteFriend.java
│       ├── SnapostdeletePhoto.java
│       ├── SnapostLogin.java
│       ├── SnapostnewAlbum.java
│       ├── SnapostnewRegister.java
```
- 桔子：
```
│       ├── SnapostnewShare.java
│       ├── SnapostnewUpload.java
│       ├── SnapostPassword.java
│       ├── SnapostpicProcess.java
│       ├── SnapostRegister.java
│       ├── SnapostsaveNewPic.java
│       ├── SnapostSetting.java
│       ├── SnapostWAnnounce.java
│       └── SnapostWarnUser.java
```
#### 提交方法：
- 解压我发的Snapost3.zip，获得一个Snapost3文件夹
- Eclipse打开，选择Import->Git->Projects from git->Existing local repository->Add...
- 选中Snapost3文件夹->finish，返回之前的界面，选中Snapost3/.git，next->Import existing project->next->finish
