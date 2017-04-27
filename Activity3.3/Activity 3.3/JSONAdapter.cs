using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Java.Lang;

namespace Activity_3._3
{
    class JSONAdapter : BaseAdapter
    {
        Activity activity;
        JavaList<Post> data;

        public JSONAdapter(Activity activity, JavaList<Post> data)
        {
            this.activity = activity;
            this.data = data;
        }

        public override int Count => data.Count;

        public override Java.Lang.Object GetItem(int position)
        {
            return data[position];
        }

        public override long GetItemId(int position)
        {
            return data[position].id;
        }

        public override View GetView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.From(this.activity).Inflate(Resource.Layout.JSON_Row, null);
            }

            TextView rowTitle = this.activity.FindViewById<TextView>(Resource.Id.tv_row_title);
            TextView rowBody = this.activity.FindViewById<TextView>(Resource.Id.tv_row_body);
            Post post = (Post)this.GetItem(position);

            rowTitle.Text = post.title;
            rowBody.Text = post.body;

            return convertView;
        }
    }
}