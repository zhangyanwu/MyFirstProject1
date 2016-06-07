package com.example.mycomputer.homework;

import java.util.List;

/**
 * Created by MyComputer on 2016/5/28.
 */
public class joke {

    /**
     * result : [{"content":"狐媚的妖精，瞬间变逗比","hashId":"2F18316067604DF34B403390A8BA5EB5","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=9a6a4a3ab9814ff6aad5be51b4a250b1.gif"},{"content":"堪比人参价值的白萝卜","hashId":"CD9A79186BD533618C8CB707F5AFAE91","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=778f30f9110d4203af08e91819485073.jpg"},{"content":"胸小的妹子，终于有了有沟之路了","hashId":"D95FAB70A072E77CA923246D485BE02F","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=d745f3289cba4ad0bb8d9df4b865fc5a.jpg"},{"content":"夏日神袜，性感，环保","hashId":"CA8B54488E0FFAA2D674FF3E774422B7","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=3d472c2c15a54cc08434ab5515ebd00d.jpg"},{"content":"妹子网聊中，时刻准备着....","hashId":"031DE3179789D1545B5AAF8CE66F8C41","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=bcf83e155c0e4f899373e420569a4c89.jpg"},{"content":"女王范，有钱任性啊","hashId":"6E03E81ACE1B180C7C150862AF83F6E4","unixtime":"1464413604","updatetime":"2016-05-28 13:33:24","url":"http://api.avatardata.cn/Joke/Img?file=565bbe2cf3b24ecba531d2516241de77.jpg"},{"content":"每天挤公交的自由女神","hashId":"49D102AC3606F3492FD4DF582C4D4D2C","unixtime":"1464341592","updatetime":"2016-05-27 17:33:12","url":"http://api.avatardata.cn/Joke/Img?file=dc12d8018f00436bb5a1a88507452b43.png"},{"content":"刘备浇水。。（b站弹幕梗，我笑点好低。。。","hashId":"3ADF1D3AE36ABBA3284DDF0A6BE358FD","unixtime":"1464341592","updatetime":"2016-05-27 17:33:12","url":"http://api.avatardata.cn/Joke/Img?file=835927c911d24f8891f5c7a4c65594e0.png"},{"content":"那些年，动漫中我们没能领悟的真理","hashId":"9C09DEE786D63ACE7C43B0625DB1850F","unixtime":"1464341592","updatetime":"2016-05-27 17:33:12","url":"http://api.avatardata.cn/Joke/Img?file=1fe6e9f474c44ec3bfa8299a5297057c.png"},{"content":"韩国抖奶舞！！看爆你的眼球！！！","hashId":"B39834864FF4732E8461D0CACD6D2551","unixtime":"1464341592","updatetime":"2016-05-27 17:33:12","url":"http://api.avatardata.cn/Joke/Img?file=27eb596cc3374a6d9ad19c9deb0fced2.gif"}]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    /**
     * content : 狐媚的妖精，瞬间变逗比
     * hashId : 2F18316067604DF34B403390A8BA5EB5
     * unixtime : 1464413604
     * updatetime : 2016-05-28 13:33:24
     * url : http://api.avatardata.cn/Joke/Img?file=9a6a4a3ab9814ff6aad5be51b4a250b1.gif
     */

    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String content;
        private String hashId;
        private String unixtime;
        private String updatetime;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
