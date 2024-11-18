package com.app.abc.data.producer

import android.content.Context
import com.app.abc.data.model.Article
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataSource @Inject constructor() {

    val businessList = listOf(
            Article("Bitcoin hits new high",
                "https://apnews.com/article/bitcoin-crypto-donald-trump-election-c2e2a1a895288c5e9c0df2721012a5bb",
                "https://dims.apnews.com/dims4/default/b776c07/2147483647/strip/true/crop/6336x3564+0+330/resize/1440x810!/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2Fde%2F55%2Fc2820b210639049885eab870960b%2F4d870bfea8d04df59a6dc6090c4f98d9",
                "2024-11-06T11:59:00Z"),
        Article("CVS posts mixed earnings",
            "https://www.cnbc.com/2024/11/06/cvs-health-cvs-earnings-q3-2024.html",
            "https://image.cnbcfm.com/api/v1/image/107327102-1701804272247-107327102-16988587922023-10-30t154234z_1924471395_rc2234a6fa1u_rtrmadp_0_usa-labor-pharmacists.jpg?v=1705005458&w=1920&h=1080",
            "2024-11-06T11:31:13Z"),
        Article("DJT stock surges",
            "https://finance.yahoo.com/news/djt-stock-surges-in-premarket-trading-as-trump-clinches-election-win-071432845.html",
            "https://s.yimg.com/ny/api/res/1.2/VnUwORU6xKurnRubo4BdVw--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD03OTU-/https://s.yimg.com/os/creatr-uploaded-images/2024-10/ee2faec0-9b86-11ef-b3fa-404ad489495f",
            "2024-11-06T11:25:50Z"),
        Article(
            "Fed readies rate cut",
            "https://www.wsj.com/economy/central-banking/fed-readies-a-rate-cut-and-faces-these-four-questions-d32c9e20",
            null,
            "2024-11-06T11:19:00Z"),
        Article(
            "Tech giants' outlook",
            "https://www.businessinsider.com/donald-trump-presidency-affect-big-tech-2024-11",
            "https://i.insider.com/6724e0c69b3250dbbceba197?width=1200&format=jpeg",
            "2024-11-06T10:57:00Z"
        ),
        Article(
            "Top stock movers",
            "https://www.barrons.com/articles/stock-market-movers-71c74dcd",
            null,
            "2024-11-06T10:50:00Z"
        ),
        Article(
            "China markets drop",
            "https://www.reuters.com/markets/asia/chinas-markets-drop-trump-presidency-looms-2024-11-06/",
            "https://www.reuters.com/resizer/v2/V3NERNLLXJMFJJCGLV4SUC5JSQ.jpg?auth=134b83649a7cf352f4dd603b9dd950f817d90183088faa0224859bfce2b4e8f0&height=1005&width=1920&quality=80&smart=true",
            "2024-11-06T08:51:19Z"
        )
    )
    val healthList = listOf(
            Article("Rising Cancer Rates Among Youth",
                "https://www.usatoday.com/story/life/health-wellness/2024/11/04/james-van-der-beek-jenna-fischer-cancer-young/75576304007/",
                "https://www.usatoday.com/gcdn/authoring/authoring-images/2024/11/03/USAT/76033525007-gty-1176245187.JPG?crop=2666,1500,x0,y0&width=2666&height=1500&format=pjpg&auto=webp",
                "2024-11-06T10:10:04Z"),
        Article("Binge Drinking in Older Adults",
            "https://fortune.com/well/article/binge-drinking-older-adults/",
            "https://fortune.com/img-assets/wp-content/uploads/2024/10/GettyImages-140642189-e1730395475231.jpg?resize=1200,600",
            "2024-11-06T07:34:42Z"),
        Article("Health of My Prince",
            "https://www.nj.com/advice/2024/11/dear-annie-after-two-years-of-kissing-frogs-ive-found-my-prince-but-hes-not-in-good-health.html",
            "https://www.nj.com/resizer/v2/6PWAWGTKTFHOZF4VJALHFHE3VU.png?auth=90912d1a3bfc5998cf6cfab1ce6f47e617eb137d87e48fae0600341aca4fda0b&width=1280&quality=90",
            "2024-11-05T22:30:00Z"),
        Article(
            "Gene Tweaking for Longevity",
            "https://bgr.com/science/scientists-can-tweak-one-gene-to-extend-lifespans-by-up-to-30/",
            "https://bgr.com/wp-content/uploads/2022/03/AdobeStock_141880562.jpeg?quality=82&strip=all",
            "2024-11-05T20:44:00Z"),
    )
    val technologyList = listOf(
            Article("Switch 2 Backward-Compatible",
                "https://www.ign.com/articles/nintendo-switch-2-will-officially-be-backward-compatible-with-original-switch-games",
                "https://assets-prd.ignimgs.com/2024/11/06/where-to-buy-a-switch-before-christmas-ign-1724596939452-1730874221966.png?width=1280",
                "2024-11-06T06:37:12Z"),
        Article("Metacritic Responds",
            "https://www.pushsquare.com/news/2024/11/metacritic-responds-to-ongoing-dragon-age-the-veilguard-review-bombing-campaign",
            "https://images.pushsquare.com/e37c01ed1266a/1280x720.jpg",
            "2024-11-06T05:00:00Z"),
        Article("Pixel Update Revealed",
            "http://9to5google.com/2024/11/05/november-2024-pixel-update/",
            "https://i0.wp.com/9to5google.com/wp-content/uploads/sites/4/2024/08/google-pixel-9-pro-series-3-3.jpg?resize=1200%2C628&quality=82&strip=all&ssl=1",
            "2024-11-06T01:19:00Z"),
        Article(
            "Mozilla Foundation Layoffs",
            "https://www.theregister.com/2024/11/06/mozilla_foundation_layoffs/",
            "https://regmedia.co.uk/2021/03/11/shutterstock_firefox_logo.jpg",
            "2024-11-06T01:19:00Z"),
        Article(
            "Prime Video Recaps",
            "http://deadline.com/2024/11/prime-video-amazon-x-ray-recaps-generative-ai-original-series-1236168470/",
            "https://deadline.com/wp-content/uploads/2024/11/Amazon-recaps.jpg?w=1024",
            "2024-11-06T00:36:00Z"),
        Article(
            "GM Rejects CarPlay",
            "https://www.theautopian.com/this-interview-with-gms-software-head-reveals-the-fundamental-mistake-gm-made-by-rejecting-carplay-and-android-auto/",
            "https://images-stag.jazelc.com/uploads/theautopian-m2en/gm_carplay_seamless_top.jpg",
            "2024-11-05T23:38:33Z"),
        Article(
            "Track Election Results",
            "https://www.zdnet.com/article/track-us-election-results-on-your-iphone-ipad-or-apple-watch-heres-how/",
            "https://www.zdnet.com/a/img/resize/e5ac304e6b6c776c60d239e9b7553a19ea7b2590/2024/11/05/cb8fef55-7eb0-4b92-bd2c-b008a6a833fc/ivoted45gettyimages-1064310434.jpg?auto=webp&fit=crop&height=675&width=1200",
            "2024-11-05T23:37:00Z"),
    )
    val sportList = listOf(
        Article(
            "MLB Team Calls Soto",
            "https://www.si.com/mlb/one-surprising-mlb-team-called-juan-soto-free-agency",
            "https://images2.minutemediacdn.com/image/upload/c_crop,w_6540,h_3678,x_0,y_193/c_fill,w_1440,ar_16:9,f_auto,q_auto,g_auto/images/ImagnImages/mmsport/si/01jc27ztr8venm2nxcej.jpg",
            "2024-11-07T03:02:49Z"),
        Article(
            "Betts Returns Infield",
            "https://www.espn.com/mlb/story/_/id/42238888/dodgers-betts-likely-play-second-base-shortstop-25",
            "https://a4.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0402%2Fr1313309_1296x729_16%2D9.jpg",
            "2024-11-07T02:38:00Z"),
        Article(
            "LeBron vs. Morant",
            "https://www.youtube.com/watch?v\\\\u003dsgHCVKpMjOE",
            null,
            "2024-11-07T02:30:23Z"),
        Article(
            "Woman Drops Charges",
            "https://www.si.com/college/georgia/football/woman-requests-charges-to-be-dismissed-against-georgia-s-colbie-young-01jc26nhj1ez",
            "https://images2.minutemediacdn.com/image/upload/c_crop,w_5130,h_2885,x_0,y_0/c_fill,w_1440,ar_16:9,f_auto,q_auto,g_auto/images/ImagnImages/mmsport/dawgs_daily/01jc26w9xm2zyec64dhe.jpg",
            "2024-11-07T02:23:23Z"),
        Article(
            "Shanahan on McCaffrey",
            "https://www.nbcsports.com/nfl/profootballtalk/rumor-mill/news/kyle-shanahan-stays-coy-about-christian-mccaffrey",
            "https://nbcsports.brightspotcdn.com/dims4/default/9af70f9/2147483647/strip/true/crop/4742x2667+0+0/resize/1440x810!/quality/90/?url=https%3A%2F%2Fnbc-sports-production-nbc-sports.s3.us-east-1.amazonaws.com%2Fbrightspot%2Fec%2Fda%2F66a20e7645fcb3f8c19db7431bad%2Fhttps-api-imagn.com%2Frest%2Fdownload%2FimageID%3D24361158",
            "2024-11-07T01:58:59Z"),
        Article(
            "Australian Breaker Retires",
            "https://apnews.com/article/australia-olympics-breaker-retires-909872e56fa902b4743e476c7acb4af0",
            "https://dims.apnews.com/dims4/default/dd3431b/2147483647/strip/true/crop/3845x2163+0+200/resize/1440x810!/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F4f%2Fd7%2F4c312b153bafbca1d77d0e0a6fad%2Ff2aeef29da864be3bc8714597cb9195f",
            "2024-11-07T01:19:00Z"),
        Article(
            "Dak Injury Update",
            "https://www.espn.com/nfl/story/_/id/42237405/sources-cowboys-prescott-likely-longer-4-weeks",
            "https://a4.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F1028%2Fr1407152_1296x729_16%2D9.jpg",
            "2024-11-07T01:05:00Z"),
        Article(
            "Williams Speaks Out",
            "https://nypost.com/2024/11/06/sports/mike-williams-opens-up-on-what-went-wrong-with-jets-after-steelers-trade/",
            "https://nypost.com/wp-content/uploads/sites/2/2024/11/9-29-24_VC_34830-1.jpg?quality=75&strip=all&w=1024",
            "2024-11-07T00:33:00Z"),
    )

}
