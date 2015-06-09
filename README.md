# Snapost3
######  我们发现只实现网页端，平均每人的代码量就已经达到了2000行，所以PC端没有实现后台的操作，只实现的界面
#### 这是我们的文件目录结构
```
.
├── build
│   └── classes								# 这些是服务器端的class文件
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
├── jars			# 引用的外部的包
│   ├── commons-fileupload-1.3.1.jar
│   ├── commons-io-2.4.jar
│   ├── spring-web.jar
│   ├── spring-webmvc.jar
│   └── sqljdbc4.jar
├── README.md		# 你现在所看见的
├── src							# 里面是我们的所有服务器端代码
│   ├── Database		# 这里的6个类实现了服务器端的所有跟数据库相关的功能
│   │   ├── Create.java
│   │   ├── Delete.java
│   │   ├── Drop.java
│   │   ├── Insert.java
│   │   ├── Select.java
│   │   └── Update.java
│   ├── ImageProcess		# 引用了Easyimage项目的代码，完成图片美化功能
│   │   └── Image.java
│   └── Servlet			# 服务器端请求处理功能
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
├── upload	
│   └── thepath.txt
└── WebContent		# 网页界面
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
    ├── home
    │   ├── img
    │   │   ├── 095.png
    │   │   ├── 119.jpg
    │   │   ├── 12.gif
    │   │   ├── 13.gif
    │   │   ├── 14.gif
    │   │   ├── 15.gif
    │   │   ├── 15.png
    │   │   ├── 16.gif
    │   │   ├── 195.jpg
    │   │   ├── 197.jpg
    │   │   ├── 197.png
    │   │   ├── 1.gif
    │   │   ├── 1.jpg
    │   │   ├── 204.jpg
    │   │   ├── 22.png
    │   │   ├── 24.png
    │   │   ├── 31.gif
    │   │   ├── 4.jpg
    │   │   ├── 8.jpg
    │   │   ├── arrowicon.png
    │   │   ├── back.jpg
    │   │   ├── begin.png
    │   │   ├── begintask.png
    │   │   ├── changetask.png
    │   │   ├── checkmsg.png
    │   │   ├── checkpub.png
    │   │   ├── checktask.png
    │   │   ├── deletetask.png
    │   │   ├── end.png
    │   │   ├── endtask.png
    │   │   ├── false4.png
    │   │   ├── false5.png
    │   │   ├── false6.png
    │   │   ├── false.png
    │   │   ├── home1.jpg
    │   │   ├── indichange.png
    │   │   ├── mail2.jpg
    │   │   ├── mailicon.png
    │   │   ├── mail.jpg
    │   │   ├── money.jpg
    │   │   ├── msgreceive2.png
    │   │   ├── msgreceive.jpg
    │   │   ├── msgreceive.png
    │   │   ├── msgsend.jpg
    │   │   ├── msgsend.png
    │   │   ├── newtask.png
    │   │   ├── page2.jpg
    │   │   ├── page2pic.png
    │   │   ├── page2.png
    │   │   ├── pub.png
    │   │   ├── pwchange.png
    │   │   ├── reg2.png
    │   │   ├── registernew.png
    │   │   ├── reg.png
    │   │   ├── settingfalse1.png
    │   │   ├── settingfalse3.png
    │   │   ├── setting.png
    │   │   ├── stop.png
    │   │   ├── stoptask.png
    │   │   ├── task.png
    │   │   ├── timeicon.png
    │   │   ├── time.jpg
    │   │   ├── title11.gif
    │   │   ├── title1.jpg
    │   │   ├── title2.jpg
    │   │   ├── title3.jpg
    │   │   ├── weibo2.jpg
    │   │   ├── weiboicon.png
    │   │   ├── weibo.jpg
    │   │   ├── writemsg2.png
    │   │   ├── writemsg.png
    │   │   └── writepub.png
    │   └── new  2.java
    ├── img
    │   ├── 095.png
    │   ├── 119.jpg
    │   ├── 12.gif
    │   ├── 13.gif
    │   ├── 14.gif
    │   ├── 15.gif
    │   ├── 15.png
    │   ├── 16.gif
    │   ├── 195.jpg
    │   ├── 197.jpg
    │   ├── 197.png
    │   ├── 1.gif
    │   ├── 1.jpg
    │   ├── 204.jpg
    │   ├── 22.png
    │   ├── 24.png
    │   ├── 31.gif
    │   ├── 4.jpg
    │   ├── 8.jpg
    │   ├── ad.jpg
    │   ├── arrowicon.png
    │   ├── back.jpg
    │   ├── balloon.jpg
    │   ├── begin.png
    │   ├── begintask.png
    │   ├── changetask.png
    │   ├── checkmsg.png
    │   ├── checkpub.png
    │   ├── checktask.png
    │   ├── deletetask.png
    │   ├── end.png
    │   ├── endtask.png
    │   ├── false4.png
    │   ├── false5.png
    │   ├── false6.png
    │   ├── false.png
    │   ├── home1.jpg
    │   ├── indichange.png
    │   ├── mail2.jpg
    │   ├── mailicon.png
    │   ├── mail.jpg
    │   ├── money.jpg
    │   ├── msgreceive2.png
    │   ├── msgreceive.jpg
    │   ├── msgreceive.png
    │   ├── msgsend.jpg
    │   ├── msgsend.png
    │   ├── nan.jpg
    │   ├── newtask.png
    │   ├── nv.jpg
    │   ├── page2.jpg
    │   ├── page2pic.png
    │   ├── page2.png
    │   ├── pub.png
    │   ├── pwchange.png
    │   ├── reg2.png
    │   ├── registernew.png
    │   ├── reg.png
    │   ├── settingfalse1.png
    │   ├── settingfalse3.png
    │   ├── setting.png
    │   ├── stop.png
    │   ├── stoptask.png
    │   ├── task.png
    │   ├── Thumbs.db
    │   ├── timeicon.png
    │   ├── time.jpg
    │   ├── title11.gif
    │   ├── title1.jpg
    │   ├── title2.jpg
    │   ├── title3.jpg
    │   ├── weibo2.jpg
    │   ├── weiboicon.png
    │   ├── weibo.jpg
    │   ├── writemsg2.png
    │   ├── writemsg.png
    │   └── writepub.png
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
    ├── reference
    │   ├── bootstrap.min.js
    │   ├── docs.min.js
    │   └── jquery.min.js
    ├── Register.jsp
    ├── setting.jsp
    ├── setting_password.jsp
    ├── single_pic.jsp
    ├── sizefalse.jsp
    ├── title.png
    ├── upload
    └── WEB-INF			# tomcat运行依赖的文件
        ├── lib
        │   ├── commons-fileupload-1.3.1.jar
        │   └── commons-io-2.4.jar
        └── web.xml		# 服务器端url映射和servlet注册

20 directories, 245 files
```

####  大家的分工大致如下
- 张文夕：设计数据库，实现数据库连接部分的功能
- 李珍珠、王高玉：实现所有的jsp界面
- 邵菲、沈宇桔：实现servlet的所有功能

#### 改进说明  
1. 打开一个你传的文件
2. 在里面添加你要加的代码，例如：
```
    int x = 0;
    while (x){
        System.out.println("hello, world");
        int y = x;
        if (y > 1) int z;
        else break;
        /*
        	等等
        */
    }
```
3. 如果是jsp文件
```
    <%
        /* 跟上面类似的Java代码 */
    %>
```
4. 右键工程 -> Team -> Pull
5. 右键工程 -> Team -> Commit and Push