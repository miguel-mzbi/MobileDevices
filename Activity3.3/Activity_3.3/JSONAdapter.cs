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
using Org.Json;
using Android.Util;

namespace Activity_3._3
{
    class JSONAdapter : BaseAdapter
    {
        Activity activity;
        JSONArray data;

        public JSONAdapter(Activity activity, JSONArray data)
        {
            this.activity = activity;
            this.data = data;
        }

        public override int Count => data.Length();

        public override Java.Lang.Object GetItem(int position)
        {
            return data.GetJSONObject(position);
        }

        public override long GetItemId(int position)
        {
            return data.GetJSONObject(position).GetInt("id");
        }

        public override View GetView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.From(this.activity).Inflate(Resource.Layout.JSON_row, null);
            }

            TextView rowTitle = convertView.FindViewById<TextView>(Resource.Id.tv_row_title);
            TextView rowBody = convertView.FindViewById<TextView>(Resource.Id.tv_row_body);
            JSONObject post = (JSONObject)this.GetItem(position);

            rowTitle.Text = post.GetString("title");
            rowBody.Text = post.GetString("body");

            return convertView;
        }
    }
}