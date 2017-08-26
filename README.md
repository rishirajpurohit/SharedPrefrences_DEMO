# SharedPrefrences_DEMO
Basic android application showing use of shared prefrences for login and register functionality. login/register in real world apps will obviously be done using database



# Initialize
  SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs",MODE_APPEND);

# Save Data
  SharedPreferences.Editor editor = sharedPreferences.edit();
  editor.putString(key,value);
  editor.commit();

# Retrieve Data
  String value = sharedPreferences.getString(key,"default_string");



