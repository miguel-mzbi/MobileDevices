using Android.App;
using Android.Widget;
using Android.OS;
using Org.Json;
using Android.Util;

namespace Activity_3._3
{
    [Activity(Label = "Activity3.3", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity, JSONRequest.JSONListener
    {
        Button b1;
        ListView lv1;

        public void Listen(JSONArray posts)
        {
            JSONAdapter jsonAdapter = new JSONAdapter(this, posts);
            lv1.Adapter = jsonAdapter;
        }

        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            b1 = FindViewById<Button>(Resource.Id.bt_main_getJson);
            lv1 = FindViewById<ListView>(Resource.Id.lv_mai_lv);

            b1.Click += delegate
            {
                JSONRequest jsonRequest = new JSONRequest(this);
                jsonRequest.Execute("http://jsonplaceholder.typicode.com/posts");
            };
        }
    }
}

