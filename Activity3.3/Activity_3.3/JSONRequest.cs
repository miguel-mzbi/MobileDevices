using System;

using Android.OS;
using Org.Json;
using System.Net.Http;
using Android.Util;

namespace Activity_3._3
{
    class JSONRequest : AsyncTask<string, int, JSONArray>
    {

        private JSONListener listener;

        public JSONRequest(JSONListener listener)
        {
            this.listener = listener;
        }
        
        protected override JSONArray RunInBackground(params string[] @params)
        {
            JSONArray result = null;

            try
            {
                HttpClient client = new HttpClient();
                HttpResponseMessage response = client.GetAsync(@params[0]).Result;

                if (response.IsSuccessStatusCode)
                {
                    string responseString = response.Content.ReadAsStringAsync().Result;
                    //result = JsonConvert.DeserializeObject<JavaList<Post>>(responseString);
                    result = new JSONArray(responseString);
                }
            }
            catch (Exception e)
            {
                Log.Error("ERROR", e.Message);
            }

            return result;
        }

        protected override void OnPostExecute(JSONArray result)
        {
            this.listener.Listen(result);
            base.OnPostExecute(result);
        }

        public interface JSONListener
        {
            void Listen(JSONArray posts);
        }
    }
}