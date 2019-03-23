package com.example.baseproject.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.baseproject.MainActivity;
import com.example.baseproject.db.CommentBean;
import com.example.baseproject.db.CommentBeanDao;
import com.example.baseproject.db.CommentController;
import com.example.baseproject.db.GreenDaoManager;
import com.example.baseproject.utils.utils.ShareUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @author Ambrose
 * @date 2019/1/17 7:24 PM
 * @desc
 */
public class WelcomeActivity extends AppCompatActivity {

    private List<CommentBean> commentBeans;
    private CommentController commentController;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commentController= CommentController.getInstance();
        commentBeans= GreenDaoManager.getInstance().getSession().getCommentBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(CommentBeanDao.Properties.Id)
                .build()
                .list();
        init();
        Observable.timer(0, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (ShareUtils.getString(ShareUtils.USER_HEAD_URI, "") != "") {
                            Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
    private void init() {
        if (commentBeans.size()==0){
            commentController.insert(new CommentBean(null,"对于没有大学时光的我来说，大学时光真的是很美好的呢！","https://img1.doubanio.com/icon/up4471882-8.jpg","桃之夭夭",11,49,"2019-01-03","福建师范大学"));
            commentController.insert(new CommentBean(null,"大学时光是人一生中最美好的时光","https://img3.doubanio.com/icon/up17230404-2.jpg","美好时光",4,41,"2019-01-05","南京大学"));
            commentController.insert(new CommentBean(null,"大学虽说是进入社会前最后的象牙塔，但也不能浑浑噩噩度日，文章很好共勉！","https://img3.doubanio.com/icon/up1142805-1.jpg","777",5,171,"2019-01-24","江西理工大学"));
            commentController.insert(new CommentBean(null,"珍惜大学四年的时光，珍惜它带给你的不一样的经历和体会","https://img3.doubanio.com/icon/up33191425-6.jpg","吃货软妹纸",2,146,"2019-01-27","吉林师范大学"));
            commentController.insert(new CommentBean(null,"颓废的大二🐶","https://img3.doubanio.com/icon/up34617039-5.jpg","林深鹿",2,79,"2019-01-18","福建师范大学"));
            commentController.insert(new CommentBean(null,"大学生活说短也短，且行且珍惜吧","https://img3.doubanio.com/icon/up62351295-3.jpg","星星677",7,28,"2019-01-07","西藏警官高等"));
            commentController.insert(new CommentBean(null,"大学时光确实是最美的时光，青春的记忆","https://img3.doubanio.com/icon/up64182744-4.jpg","烟火女子",5,22,"2019-01-11","中南民族大学"));
            commentController.insert(new CommentBean(null,"多少人是大学毕业之后进入社会工作，才开始后悔当初光阴的虚度","https://img3.doubanio.com/icon/up3745630-4.jpg","放逐自己任天涯",9,105,"2019-01-12","武汉大学"));
            commentController.insert(new CommentBean(null,"大学时光真的美好 现在上班真的辛苦","https://img3.doubanio.com/icon/up65655264-2.jpg","二见钟情",2,79,"2019-01-06","河南科技大学"));
            commentController.insert(new CommentBean(null,"别说大学生活了，现在好后悔当初没有好好享受自己的大学生活呀","https://img3.doubanio.com/icon/up1120907-2.jpg","脆竹",9,40,"2019-01-21","山西师范大学"));
            commentController.insert(new CommentBean(null,"怀念大学时光啊！！","https://img3.doubanio.com/icon/up50952900-5.jpg","小和尚讲故事",8,169,"2019-01-19","湖南科技大学"));
            commentController.insert(new CommentBean(null,"大学时光值得珍惜","https://img3.doubanio.com/icon/up66408263-3.jpg","南笙北稚",12,88,"2019-01-09","延安大学"));
            commentController.insert(new CommentBean(null,"大学时光挺美好的 不过也得看个人选择如何度过 鸡汤共勉吧","https://img3.doubanio.com/icon/up55293977-1.jpg","且惜YK",9,46,"2019-01-16","安徽师范大学"));
            commentController.insert(new CommentBean(null,"一样颓废的大三🐶","https://img3.doubanio.com/icon/up62351295-3.jpg","星星677",5,59,"2019-01-04","塔里木大学"));
            commentController.insert(new CommentBean(null,"不同的人，不同的环境，感觉大学学到的还是挺多的","https://img1.doubanio.com/icon/up2680159-7.jpg","夏目",3,166,"2019-01-12","西华大学"));
            commentController.insert(new CommentBean(null,"赞同","https://img3.doubanio.com/icon/up3196484-4.jpg","或许不是你",11,32,"2019-01-27","广西医科大学"));
            commentController.insert(new CommentBean(null,"我还没毕业，所以我要珍惜大学生活，让自己的以后不后悔","https://img3.doubanio.com/icon/up66408263-3.jpg","南笙北稚",8,73,"2019-01-09","江西理工大学"));
            commentController.insert(new CommentBean(null,"哈哈，后悔也没有用了，好好过好现在的生活吧。","https://img3.doubanio.com/icon/up122251431-11.jpg","行走的荷尔蒙",10,120,"2019-01-02","安徽理工大学"));
            commentController.insert(new CommentBean(null,"说的太对了。","https://img3.doubanio.com/icon/up53630814-1.jpg","大耳朵图图",7,59,"2019-01-01","河北高校"));
            commentController.insert(new CommentBean(null,"可惜我没上过，有机会想去体验一下","https://img3.doubanio.com/icon/up9097703-1.jpg","仙女味的可可",4,88,"2019-01-01","新疆师范大学"));
            commentController.insert(new CommentBean(null,"大学就是我们与社会接触的过渡时期，也是人生最美好的时期，所以我们要好好抓住时间，提升自己！","https://img3.doubanio.com/icon/up28318300-6.jpg","M鹿M",10,183,"2019-01-17","江南大学"));
            commentController.insert(new CommentBean(null,"如果我当初也看到这样的文章，大学生活中应该会少了不少遗憾","https://img3.doubanio.com/icon/up4746835-5.jpg","大胡子",6,93,"2019-01-19","长春理工大学"));
            commentController.insert(new CommentBean(null,"是这样的 一起努力吧","https://img1.doubanio.com/icon/up4736000-7.jpg","海未深",9,194,"2019-01-08","安徽工业大学"));
            commentController.insert(new CommentBean(null,"回忆最珍贵 珍惜","https://img3.doubanio.com/icon/up37427304-3.jpg","z肤浅失眠中c",8,167,"2019-01-23","中国计量学院"));
            commentController.insert(new CommentBean(null,"大学比真正的社会稍微单纯一点","https://img3.doubanio.com/icon/up28318300-6.jpg","M鹿M",9,77,"2019-01-18","深圳大学"));
            commentController.insert(new CommentBean(null,"我觉得好好的去体会一切，好好谈场恋爱，好好修一门课，参加各种社团活动才算不虚度","https://img1.doubanio.com/icon/up50241755-7.jpg","糯米糍",9,56,"2019-01-05","贵州大学"));
            commentController.insert(new CommentBean(null,"如果还有大学时光，我想用来提高自己，丰富知识，提高能力，多参加活动，积累资本！","https://img3.doubanio.com/icon/up4529464-5.jpg","forest",4,82,"2019-01-10","河南工业大学"));
            commentController.insert(new CommentBean(null,"赞同，大学里无论爱情还是友谊都是最纯真的","https://img3.doubanio.com/icon/up52111273-1.jpg","白小纯",4,101,"2019-01-26","复旦大学"));
            commentController.insert(new CommentBean(null,"多读书，充实自己","https://img3.doubanio.com/icon/up50720395-4.jpg","柠檬豆豆~",2,170,"2019-01-17","黑龙江大学"));
            commentController.insert(new CommentBean(null,"是的呢，每一段旅程都有它存在的价值，让生活变得具有价值才好。","https://img3.doubanio.com/icon/up1774878-6.jpg","米小米",5,158,"2019-01-25","电子科技大学"));
            commentController.insert(new CommentBean(null,"人都是因为没有才会想要","https://img1.doubanio.com/icon/up50241755-7.jpg","糯米糍",8,96,"2019-01-27","中南大学"));
            commentController.insert(new CommentBean(null,"大学自己的时间很多 应该找些有趣的事情 有必要的事情做 作者说的蛮细的从家庭环境入手很值得称赞","https://img3.doubanio.com/icon/up54978308-1.jpg","poison",8,93,"2019-01-09","西北工业大学"));
            commentController.insert(new CommentBean(null,"上大学，是一个回忆，怀恋","https://img3.doubanio.com/icon/up30692637-4.jpg","柯柯欧尼酱",10,63,"2019-01-16","西藏大学"));
            commentController.insert(new CommentBean(null,"1大三狗表示被戳中了膝盖。都说到点子上了但是我就是做不到啊(*꒦ິ⌓꒦ີ)","https://img3.doubanio.com/icon/up2944588-4.jpg","Tonn",10,143,"2019-01-18","暨南大学"));
            commentController.insert(new CommentBean(null,"现在正在读大二，跟舍友合伙开打印店，感觉生活充实了不少。","https://img3.doubanio.com/icon/up3196484-4.jpg","或许不是你",6,68,"2019-01-25","延安大学"));
            commentController.insert(new CommentBean(null,"距离大学毕业还有两年，要好好珍惜这短暂的时光啊","https://img3.doubanio.com/icon/up62647662-1.jpg","啊咧咧💦",9,131,"2019-01-14","北京理工大学"));
            commentController.insert(new CommentBean(null,"是的，多看看书，多经历一些，交真心朋友！","https://img3.doubanio.com/icon/up4529464-5.jpg","forest",13,54,"2019-01-08","佳木斯大学"));
            commentController.insert(new CommentBean(null,"是啊，大学的时候想着玩玩玩，吃吃吃，工作了就开始后悔为什么当初没有学点什么。。","https://img3.doubanio.com/icon/up44895292-1.jpg","整什么幺蛾子",13,86,"2019-01-05","南京大学"));
            commentController.insert(new CommentBean(null,"真羡慕你啊，好好珍惜","https://img3.doubanio.com/icon/up4529464-5.jpg","forest",5,91,"2019-01-22","电子科技大学"));
            commentController.insert(new CommentBean(null,"大学的时间很多，我也努力过，做过一些有意义的事，但是大多荒废了，我会珍惜剩下的时间","https://img3.doubanio.com/icon/up56262255-1.jpg","逃离色彩",7,59,"2019-01-13","西藏警官高等"));
            commentController.insert(new CommentBean(null,"这是一个值得珍藏的记忆时光，希望学弟学妹们不要虚度吧","https://img3.doubanio.com/icon/up1982564-2.jpg","花开了",2,120,"2019-01-19","华中师范大学"));
            commentController.insert(new CommentBean(null,"大学时光真的很美好 也是我们进入社会的一个过渡期 我们要珍惜 这篇文章写的挺好的","https://img3.doubanio.com/icon/up44602979-2.jpg","every",8,134,"2019-01-19","黑龙江大学"));
            commentController.insert(new CommentBean(null,"在大学自己的规划有的时候也是败在了懒上","https://img3.doubanio.com/icon/up44793620-2.jpg","olivia",6,179,"2019-01-24","塔里木大学"));
            commentController.insert(new CommentBean(null,"还在大学生活中 生活里还是会很有迷茫 在大学里过度好 是对我们步入社会最好的磨砺","https://img3.doubanio.com/icon/up54978308-1.jpg","poison",9,60,"2019-01-04","武汉大学"));
            commentController.insert(new CommentBean(null,"赞同，我也会！","https://img3.doubanio.com/icon/up4529464-5.jpg","forest",13,200,"2019-01-06","南开大学"));
            commentController.insert(new CommentBean(null,"大学的时光是非常好的 我们要好好珍惜大学的时光 ","https://img3.doubanio.com/icon/up41469142-1.jpg","清独",11,51,"2019-01-01","西藏职业技术"));
            commentController.insert(new CommentBean(null,"大学就像一个炼丹炉 我们在里边不断磨练自己不断成长 才不枉这四年","https://img3.doubanio.com/icon/up3230318-4.jpg","FIRE",7,108,"2019-01-22","海南政法学院"));
            commentController.insert(new CommentBean(null,"很羡慕别人的大学生活，那一段时光，是每个人一生当中最美好的时光！","https://img3.doubanio.com/icon/up3817490-6.jpg","灼灼桃花",8,101,"2019-01-04","武汉大学"));
            commentController.insert(new CommentBean(null,"想到已经成为老学姐了就一阵心酸(つД`)，特别羡慕生活充实的人。","https://img3.doubanio.com/icon/up2944588-4.jpg","Tonn",11,30,"2019-01-02","海南医学院"));
            commentController.insert(new CommentBean(null,"大学中起点定位很重要，虽然不想提阶级，可是只有认清自己，才能定好目标。其次，要多锻炼身体，还有，交际不要太偏社会化，要多学习，充实自己。","https://img3.doubanio.com/icon/up45908698-1.jpg","雨婷",9,106,"2019-01-01","福建农林大学"));
            commentController.insert(new CommentBean(null,"是啊 后悔自己当时没好好过这几年","https://img3.doubanio.com/icon/up150109429-4.jpg","小白",11,24,"2019-01-14","兰州理工大学"));
            commentController.insert(new CommentBean(null,"大学时光匆匆 珍惜时间享受青春 定","https://img3.doubanio.com/icon/up3230318-4.jpg","FIRE",11,102,"2019-01-09","河南科技大学"));
            commentController.insert(new CommentBean(null,"若是在大一那会看到这篇文章的话，或许现在不会是这个样子吧，看完了好想把大学再重新上一遍，每天过的充充实实，而现在只能是珍惜这仅剩下的几个月了。趁这几个月再做一些改变","https://img3.doubanio.com/icon/up58887521-4.jpg","枭雄",11,73,"2019-01-11","琼州学院"));
            commentController.insert(new CommentBean(null,"多读书，参加社团，活动，不要让自己的大学过得想一条咸鱼","https://img3.doubanio.com/icon/up44895292-1.jpg","整什么幺蛾子",3,143,"2019-01-25","海口经济学院"));
            commentController.insert(new CommentBean(null,"理性看待阶层的差异，加强运动","https://img3.doubanio.com/icon/up49967715-1.jpg","samantha",8,71,"2019-01-13","哈尔滨工业大"));
            commentController.insert(new CommentBean(null,"大学时光真的挺短的，不要虚度了，无论什么阶层都好，都要找到自己的目标，多点看书，不要随便逃课，以后才更有准备","https://img3.doubanio.com/icon/up1841794-3.jpg","金小手的首饰",11,152,"2019-01-24","海南政法学院"));
            commentController.insert(new CommentBean(null,"对大三的我很有用，真的要更珍惜时间了。","https://img3.doubanio.com/icon/up56550067-5.jpg","帅萌小哥哥",8,168,"2019-01-27","长春理工大学"));
            commentController.insert(new CommentBean(null,"最美时光 都在大学","https://img3.doubanio.com/icon/up37427304-3.jpg","z肤浅失眠中c",5,28,"2019-01-21","合肥工业大学"));
            commentController.insert(new CommentBean(null,"楼主说得有道理，但我不赞同某些说法。读大学就在于解决第一条，消减差距。如果一开始就自己明确阶级，那对之后的人际关系与心理发展有影响。","https://img3.doubanio.com/icon/up2583318-1.jpg","酒窝被偷了",4,27,"2019-01-14","河南农业大学"));
            commentController.insert(new CommentBean(null,"大学就应该充实自己 把该考的证件都考下来 对毕业有好处","https://img3.doubanio.com/icon/up54978308-1.jpg","poison",10,26,"2019-01-23","哈尔滨工业大"));
            commentController.insert(new CommentBean(null,"大学不仅学专业知识还有人际交往等等 很有意思","https://img3.doubanio.com/icon/up3230318-4.jpg","FIRE",9,105,"2019-01-06","大连大学"));
            commentController.insert(new CommentBean(null,"身为一个即将要毕业的大学生，小编说的这些真的都很对，大学时代美好我想我一辈子也不会忘记我的大学生活","https://img3.doubanio.com/icon/up2559534-1.jpg","依如你",12,125,"2019-01-01","长安大学"));
            commentController.insert(new CommentBean(null,"现在大三了才开始后悔没有利用好自己的大学时光，好想重新来过。好好学习，好好锻炼身体，不把太多时间放在不必要的人和事身上，可惜，总是失去了才懂得！","https://img3.doubanio.com/icon/up4671096-4.jpg","步履不停",3,86,"2019-01-18","兰州交通大学"));
            commentController.insert(new CommentBean(null,"楼主总结的很好啊，我是属于第一种家境普通的，确实根本没有资本用四年的时间去享受，对于我来说真的只有好好学习专业了，求毕了业能混个温饱吧","https://img3.doubanio.com/icon/up43244684-2.jpg","骑猪看夕阳",11,54,"2019-01-18","西南大学"));
            commentController.insert(new CommentBean(null,"大学时光，就是一段让你适应社会的时光！要知道，大学，就是一个社会的雏形，你能在大学时候为以后步入社会做好很多准备！","https://img3.doubanio.com/icon/up3088922-4.jpg","灼灼其华",8,148,"2019-01-11","湖南大学"));
            commentController.insert(new CommentBean(null,"一起加油吧，但是有很多时候还是身不由己","https://img3.doubanio.com/icon/up58887521-4.jpg","枭雄",12,134,"2019-01-22","东北大学"));
            commentController.insert(new CommentBean(null,"对啊 所以一定要珍惜","https://img3.doubanio.com/icon/up44602979-2.jpg","every",2,144,"2019-01-13","同济大学"));
            commentController.insert(new CommentBean(null,"对，好在我们都年轻，还能改变。","https://img3.doubanio.com/icon/up2583318-1.jpg","酒窝被偷了",6,196,"2019-01-20","中国医科大学"));
            commentController.insert(new CommentBean(null,"无论是工作还是学习那种时光都不再有了","https://img3.doubanio.com/icon/up54332974-3.jpg","一个人的旅行",3,106,"2019-01-18","西华大学"));
            commentController.insert(new CommentBean(null,"好好珍惜 会有不一样的体验的","https://img3.doubanio.com/icon/up150109429-4.jpg","小白",10,88,"2019-01-25","西北民族大学"));
            commentController.insert(new CommentBean(null,"有了阶层意识，才会想要去缩小","https://img3.doubanio.com/icon/up49967715-1.jpg","samantha",9,72,"2019-01-23","天津理工大学"));
            commentController.insert(new CommentBean(null,"趁我现在还在大学，要好好珍惜自己的大学时光！","https://img3.doubanio.com/icon/up2859720-4.jpg","猫巷少女",12,99,"2019-01-01","中国美术学院"));
            commentController.insert(new CommentBean(null,"我和你有一样的感触，不会忘记！","https://img3.doubanio.com/icon/up4671096-4.jpg","步履不停",10,107,"2019-01-05","山西财经大学"));
            commentController.insert(new CommentBean(null,"很快呀","https://img3.doubanio.com/icon/up54332974-3.jpg","一个人的旅行",2,35,"2019-01-08","甘肃农业大学"));
            commentController.insert(new CommentBean(null,"有定位，有目标才活得清楚","https://img1.doubanio.com/icon/up3348942-7.jpg","Bow",7,156,"2019-01-01","内蒙古师范大"));
            commentController.insert(new CommentBean(null,"是呀，珍惜","https://img3.doubanio.com/icon/up64182744-4.jpg","烟火女子",3,133,"2019-01-21","山西师范大学"));
            commentController.insert(new CommentBean(null,"其实也是拖延症，很多事情逼到眼前了才去做","https://img3.doubanio.com/icon/up1841794-3.jpg","金小手的首饰",2,194,"2019-01-18","西藏藏医学院"));
            commentController.insert(new CommentBean(null,"楼主总结的很好啊，我是属于第一种家境普通的，确实根本没有资本用四年的时间去享受，对于我来说真的只有好好学习专业了，求毕了业能混个温饱吧","https://img3.doubanio.com/icon/up43244684-2.jpg","骑猪看夕阳",11,109,"2019-01-17","河北工业大学"));
            commentController.insert(new CommentBean(null,"如果可以，真的想回到大一的时候","https://img3.doubanio.com/icon/up44895292-1.jpg","整什么幺蛾子",6,69,"2019-01-07","兰州交通大学"));
            commentController.insert(new CommentBean(null,"大一颓废了一年！！在床上挺尸","https://img3.doubanio.com/icon/up45743359-2.jpg","瓜瓜",4,57,"2019-01-16","大连海事大学"));
            commentController.insert(new CommentBean(null,"没有错就是这样，趁着现在做出改变吧","https://img3.doubanio.com/icon/up58887521-4.jpg","枭雄",6,106,"2019-01-20","河北师范大学"));
            commentController.insert(new CommentBean(null,"大学生活堪比一个小型社会，林子大了什么鸟都有，对于我们来说也是个磨练的机会。","https://img3.doubanio.com/icon/up44923003-6.jpg","大姑娘",10,119,"2019-01-01","哈尔滨理工大"));
            commentController.insert(new CommentBean(null,"说的没错，一眨眼的功夫就度过了大学时光","https://img3.doubanio.com/icon/up2559534-1.jpg","依如你",13,159,"2019-01-15","内蒙古农业大"));
            commentController.insert(new CommentBean(null,"大学时光感觉过的很快，一晃2年过去了，接下来一定更加努力，更加珍惜。","https://img3.doubanio.com/icon/up3550737-3.jpg","这就是我",8,34,"2019-01-19","安徽理工大学"));
            commentController.insert(new CommentBean(null,"有最美的爱情，有最纯的友谊","https://img3.doubanio.com/icon/up52111273-1.jpg","白小纯",3,132,"2019-01-24","四川师范大学"));
            commentController.insert(new CommentBean(null,"赞同","https://img3.doubanio.com/icon/up41469142-1.jpg","清独",4,183,"2019-01-17","哈尔滨理工大"));
            commentController.insert(new CommentBean(null,"同感","https://img3.doubanio.com/icon/up56550067-5.jpg","帅萌小哥哥",5,170,"2019-01-09","大连理工大学"));
            commentController.insert(new CommentBean(null,"还有3个月我就要告别校园生活了，珍惜这三个月的时光是最重要的","https://img3.doubanio.com/icon/up53930706-5.jpg","骑着神马找白马",12,63,"2019-01-06","长春工业大学"));
            commentController.insert(new CommentBean(null,"大学四年其实真的很短，可以学到很多，也可以一无所获，且行且珍惜","https://img1.doubanio.com/icon/up43226234-19.jpg","小撒小白",4,173,"2019-01-22","海口经济学院"));
            commentController.insert(new CommentBean(null,"我都有点后悔了 所以现在在最后的半年努力","https://img3.doubanio.com/icon/up2559534-1.jpg","依如你",9,33,"2019-01-12","广西大学"));
            commentController.insert(new CommentBean(null,"上大学的那几年没有好好的学习现在后悔莫及","https://img3.doubanio.com/icon/up164266033-1.jpg","一缕阳光",10,103,"2019-01-06","东南大学"));
            commentController.insert(new CommentBean(null,"作者总结的很好，回想起自己的大学时光，本着不虚度光阴的心，到头来才发现自己还是有些愧对自己的…","https://img3.doubanio.com/icon/up1774878-6.jpg","米小米",4,59,"2019-01-06","中国医科大学"));
            commentController.insert(new CommentBean(null,"我并没有这么认为 消除差距并不应该是我们在大学做的事情 如果大学只挣到了钱 没有把专业课学好 那要毕业证有什么用呢 还不如先去打工 既然要学习 就是来学习知识的 表明阶级也没什么不好 你懂的自己家里的困境 懂得我们与他人的差距 就懂得更好的学习知识 充实自己","https://img3.doubanio.com/icon/up54978308-1.jpg","poison",13,154,"2019-01-14","哈尔滨理工大"));
            commentController.insert(new CommentBean(null,"对呀 我哦的要珍惜","https://img3.doubanio.com/icon/up41469142-1.jpg","清独",9,56,"2019-01-15","汕头大学"));
            commentController.insert(new CommentBean(null,"加油","https://img3.doubanio.com/icon/up4746835-5.jpg","大胡子",3,102,"2019-01-09","福建师范大学"));
            commentController.insert(new CommentBean(null,"嗯，确实，大学时光是真的快乐啊。","https://img3.doubanio.com/icon/up2583318-1.jpg","酒窝被偷了",12,151,"2019-01-25","天水师范学院上海交通大学"));
            commentController.insert(new CommentBean(null,"大学是个提升和认清自己的几年 好好珍惜 会有特别的收货的","https://img3.doubanio.com/icon/up150113708-4.jpg","稻香",12,59,"2019-01-24","深圳大学"));
            commentController.insert(new CommentBean(null,"我都毕业了，看着幡然醒悟又在惋惜","https://img1.doubanio.com/icon/up43226234-19.jpg","小发放白",13,140,"2019-01-27","河南大学"));
            commentController.insert(new CommentBean(null,"我觉得大学时光看似美好，其实如果要有出息的话也没那么轻松啦","https://img3.doubanio.com/icon/up43244684-2.jpg","骑猪看夕阳",7,26,"2019-01-14","天津师范大学"));
            commentController.insert(new CommentBean(null,"时间不多更要珍惜 只要过好剩下的大学时间 大学一样不虚度","https://img3.doubanio.com/icon/up44602979-2.jpg","every",9,178,"2019-01-09","琼州学院"));
            commentController.insert(new CommentBean(null,"对的！其实在大学如果充分利用好时间可以学到很多","https://img3.doubanio.com/icon/up45743359-2.jpg","瓜瓜",3,83,"2019-01-05","哈尔滨工业大"));
            commentController.insert(new CommentBean(null,"共勉+1进入社会也不要忘了丰富自己","https://img3.doubanio.com/icon/up44895292-1.jpg","整什么幺蛾子",5,106,"2019-01-04","华东交通大学"));
            commentController.insert(new CommentBean(null,"大学是步入社会的最后一步","https://img3.doubanio.com/icon/up49967715-1.jpg","samantha",8,165,"2019-01-15","延边大学"));
            commentController.insert(new CommentBean(null,"扎Zn了老Fe😂😂😂","https://img3.doubanio.com/icon/up165766458-1.jpg","Cannocannocan",4,128,"2019-01-04","华东师范大学"));
            commentController.insert(new CommentBean(null,"最后一年还来得及","https://img1.doubanio.com/icon/up43226234-19.jpg","小小白",9,34,"2019-01-20","内蒙古工业大"));
            commentController.insert(new CommentBean(null,"说的挺好的，大二狗，准备考研但是现在没什么目标还有点迷茫，干了这碗鸡汤去背单词准备四级啦。","https://img3.doubanio.com/icon/up78675144-4.jpg","行歌",13,72,"2019-01-10","北京理工大学"));
            commentController.insert(new CommentBean(null,"我们应该趁现在还在学校学习，多想想未来要做什么，并向自己的目标努力，现在处于大二的我更要珍惜大学的时光","https://img3.doubanio.com/icon/up4532609-2.jpg","one！",4,199,"2019-01-03","延边大学"));
            commentController.insert(new CommentBean(null,"努力加油，珍惜大学时光","https://img3.doubanio.com/icon/up38587215-3.jpg","明年打老虎",8,136,"2019-01-09","吉林师范大学"));
            commentController.insert(new CommentBean(null,"日子太好混了，四年过去才发现没有好好学到什么","https://img3.doubanio.com/icon/up154674864-1.jpg","吕优秀",3,150,"2019-01-02","吉林大学"));
            commentController.insert(new CommentBean(null,"是啊，家境普通就只能靠自己拼搏了","https://img3.doubanio.com/icon/up1841794-3.jpg","金小手的首饰",4,167,"2019-01-11","哈尔滨工程大"));
            commentController.insert(new CommentBean(null,"我没有上过大学，对大学还是有种憧憬的。不过听别人说，大学生活好混乱。","https://img3.doubanio.com/icon/up38852281-6.jpg","安筱冉",8,141,"2019-01-15","长春工业大学"));
            commentController.insert(new CommentBean(null,"保持一个好心态 在大学里丰富自己的内心世界 ","https://img3.doubanio.com/icon/up3615494-2.jpg","积攒一身酷",6,103,"2019-01-23","福建农林大学"));
            commentController.insert(new CommentBean(null,"很容易就颓废了，一定要坚持，不要随波逐流，要追寻自己的梦想","https://img3.doubanio.com/icon/up3550737-3.jpg","这就是我",2,84,"2019-01-20","中国医科大学"));
            commentController.insert(new CommentBean(null,"是呀，珍惜这最美好的时光","https://img3.doubanio.com/icon/up2469970-3.jpg","西贝卡路",10,153,"2019-01-07","延边大学"));
            commentController.insert(new CommentBean(null,"现在都有这种感觉了，抓住大学时间的尾巴～","https://img3.doubanio.com/icon/up4671096-4.jpg","步履不停",12,112,"2019-01-24","天津工业大学"));
            commentController.insert(new CommentBean(null,"加一_(:з」∠)_在宿舍呆的时间最久了","https://img3.doubanio.com/icon/up78675144-4.jpg","行歌",9,80,"2019-01-15","海南师范大学"));
            commentController.insert(new CommentBean(null,"同感啊！感觉自己白白浪费了三年…","https://img3.doubanio.com/icon/up1774878-6.jpg","米小米",10,65,"2019-01-14","中国科学技术"));
            commentController.insert(new CommentBean(null,"继续加油哦 哈哈","https://img3.doubanio.com/icon/up54332974-3.jpg","一个人的旅行",2,162,"2019-01-26","天津师范大学"));
            commentController.insert(new CommentBean(null,"可是人总要过去了才懂得珍惜","https://img3.doubanio.com/icon/up49967715-1.jpg","samantha",9,168,"2019-01-26","内蒙古民族大"));
            commentController.insert(new CommentBean(null,"都是看个人的，无论什么大学都是有好有坏，所以自己要有底线","https://img3.doubanio.com/icon/up1841794-3.jpg","金小手的首饰",10,90,"2019-01-16","华东理工大学"));
            commentController.insert(new CommentBean(null,"对于正处于大三的我，大学都过完一半了，才知道自己想要干什么，其实大学真的是一定要想好，你考大学是干嘛的，不要虚度了时光","https://img3.doubanio.com/icon/up52346930-1.jpg","七月",8,36,"2019-01-14","西华大学"));
            commentController.insert(new CommentBean(null,"说的对 大学就是一个小型社会 我们在大学里会收获很多东西","https://img3.doubanio.com/icon/up44602979-2.jpg","every",8,110,"2019-01-27","内蒙古农业大"));   commentController.insert(new CommentBean(null,"努力吧，趁还有时间。","https://img3.doubanio.com/icon/up56550067-5.jpg","帅萌小哥哥",11,140,"2019-01-15","吉林高校"));
            commentController.insert(new CommentBean(null,"珍惜 眼前 享受生活吧 大学最美的时光","https://img3.doubanio.com/icon/up164265934-1.jpg","纷纷飘天下",12,172,"2019-01-27","南华大学"));
            commentController.insert(new CommentBean(null,"想想自己就过了三年的咸鱼🐠心口疼","https://img3.doubanio.com/icon/up44923003-6.jpg","大姑娘",6,127,"2019-01-27","内蒙古师范大"));
            commentController.insert(new CommentBean(null,"对，大学时光一辈子最美好的记忆！","https://img3.doubanio.com/icon/up2859720-4.jpg","猫巷少女",8,142,"2019-01-21","同济大学"));
        }
    }
}
