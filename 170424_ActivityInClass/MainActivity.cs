using Android.App;
using Android.Widget;
using Android.OS;

namespace XamarinClaseMartes
{
    [Activity(Label = "XamarinClaseMartes", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity
    {
        private EditText ed1;
        private Button b1;
        private Button b2;

        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);

            // Set our view from the "main" layout resource
            SetContentView (Resource.Layout.Main);

            ed1 = FindViewById<EditText>(Resource.Id.ed1);
            b1 = FindViewById<Button>(Resource.Id.b1);
            b2 = FindViewById<Button>(Resource.Id.b2);

            b1.Click += delegate
            {
                Toast.MakeText(this, ed1.Text, ToastLength.Short).Show();
            };

            b2.Click += delegate {
                JSONRequest request = new JSONRequest();
                request.Execute("http://jsonplaceholder.typicode.com/posts");

            };
        }
    }
}

