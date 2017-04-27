using Android.App;
using Android.Widget;
using Android.OS;
using System;
using System.Collections.Generic;
using Android.Runtime;

namespace Activity_3._3
{
    [Activity(Label = "Activity", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity, JSONRequest.JSONListener
    {
        Button b1;
        ListView lv1;

        public void Listen(JavaList<Post> posts)
        {
            JSONAdapter jsonAdapter = new JSONAdapter(this, posts);
            lv1.Adapter = jsonAdapter;
        }

        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);

            // Set our view from the "main" layout resource
            SetContentView (Resource.Layout.Main);

            b1 = FindViewById<Button>(Resource.Id.button1);
            lv1 = FindViewById<ListView>(Resource.Id.listView1);

            b1.Click += delegate
            {
                JSONRequest jsonRequest = new JSONRequest(this);
                jsonRequest.Execute("http://jsonplaceholder.typicode.com/posts");
            };
        }
    }
}

