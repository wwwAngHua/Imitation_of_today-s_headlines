package com.today.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {
            "布林肯硬要访华，叫嚣中美高层必须接触，中方回应不留情面",
            "马上天下：师长忽悠敌人上当，假死躺在棺材里，让他们放松了警惕",
            "穷台战略已打响，围岛锁台常态化！解放军已做台北血战准备",
            "我退休金5000，每月给儿媳4000，买菜遇到亲家母，我决定不再给钱",
            "何超琼有12个弟弟妹妹，却独宠何超莲，或许因她弥补了自己的遗憾",
            "两性交往时，男生最败好感的15个行为，希望你没有做过"
    };

    private String[] names = {
            "敕观天下",
            "华数影视泡面喵",
            "胖福的小木屋",
            "玲珑成长微时光",
            "担扑",
            "做一个有趣的女人"
    };

    private String[] comments = {
            "1888评",
            "1999评",
            "2333评",
            "48888评",
            "77777评",
            "9999评"
    };

    private String[] times = {
            "1小时前",
            "3小时前",
            "6小时前",
            "8小时前",
            "刚刚",
            "昨天"
    };

    private int[] images1 = {
            R.drawable.fa,
            R.drawable.fb,
            R.drawable.fc
    };

    private int[] images2 = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven
    };

    private int[] types = {1, 1, 2, 1, 2, 1};
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsBean> NewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsList = new ArrayList<NewsBean>();
        NewsBean bean;

        for (int i = 0; i < titles.length; i++) {
            bean = new NewsBean();
            bean.setId(i + 1);
            bean.setTitle(titles[i]);
            bean.setName(names[i]);
            bean.setComment(comments[i]);
            bean.setTime(times[i]);
            bean.setType(types[i]);
            switch (i) {
                case 0:
                    List<Integer> imgList0 = new ArrayList<>();
                    bean.setImgList(imgList0);
                    break;
                case 1:
                    List<Integer> imgList1 = new ArrayList<>();
                    imgList1.add(images1[i - 1]);
                    bean.setImgList(imgList1);
                    break;
                case 2:
                    List<Integer> imgList2 = new ArrayList<>();
                    imgList2.add(images2[i - 2]);
                    imgList2.add(images2[i - 1]);
                    imgList2.add(images2[i]);
                    bean.setImgList(imgList2);
                    break;
                case 3:
                    List<Integer> imgList3 = new ArrayList<>();
                    imgList3.add(images1[i - 2]);
                    bean.setImgList(imgList3);
                    break;
                case 4:
                    List<Integer> imgList4 = new ArrayList<>();
                    imgList4.add(images2[i - 1]);
                    imgList4.add(images2[i]);
                    imgList4.add(images2[i + 1]);
                    bean.setImgList(imgList4);
                    break;
                case 5:
                    List<Integer> imgList5 = new ArrayList<>();
                    imgList5.add(images1[i - 3]);
                    bean.setImgList(imgList5);
                    break;
            }
            NewsList.add(bean);

            recyclerView = findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            newsAdapter = new NewsAdapter(MainActivity.this, NewsList);
            recyclerView.setAdapter(newsAdapter);
        }
    }
}