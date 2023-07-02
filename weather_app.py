import tkinter as tk
from tkinter import messagebox
from tkinter import PhotoImage, Entry, Button, Label, Frame
from datetime import datetime
import requests
import pytz
from geopy.geocoders import Nominatim
from timezonefinder import TimezoneFinder


root = tk.Tk()
root.title("Weather App")
root.geometry("890x470+300+300")
root.configure(bg="#E9967A")
root.resizable(True, True)


def get_weather():
    """
    Fetches and displays weather information based on the user-entered city.
    """
    city = textfield.get()
    try:
        geolocator = Nominatim(user_agent="geoapiExercises")
        location = geolocator.geocode(city)
        obj = TimezoneFinder()

        result = obj.timezone_at(lng=location.longitude, lat=location.latitude)

        timezone.config(text=result)
        long_lat.config(text=f"{round(location.latitude, 4)}°N, {round(location.longitude, 4)}°E")

        home = pytz.timezone(result)
        local_time = datetime.now(home)
        current_time = local_time.strftime("%I : %M : %p")
        clock.config(text=current_time)

        # Weather API
        api = f"THE_APIIII!"

        try:
            json_data = requests.get(api).json()
            current_weather = json_data.get("current", {})
            temp = current_weather.get("temp")
            humidity = current_weather.get("humidity")
            pressure = current_weather.get("pressure")
            wind = current_weather.get("wind_speed")
            description = current_weather.get("weather", [{}])[0].get("description")

            t.config(text=f"{temp} °C" if temp is not None else "N/A")
            h.config(text=f"{humidity} %" if humidity is not None else "N/A")
            p.config(text=f"{pressure} hPa" if pressure is not None else "N/A")
            w.config(text=f"{wind} m/s" if wind is not None else "N/A")
            d.config(text=description if description is not None else "N/A")

        except requests.RequestException:
            messagebox.showerror("Error", "Failed to retrieve weather data.")
        except KeyError:
            messagebox.showerror("Error", "Failed to parse weather data.")

    except AttributeError:
        messagebox.showerror("Error", "Invalid city name.")
    except Exception as e:
        messagebox.showerror("Error", str(e))



def create_gui():
    """
    Creates the GUI elements and layouts.
    """
    # Icon
    image_icon = PhotoImage(file="weather app back-img/3535995.png")
    root.iconphoto(False, image_icon)

    # Box
    round_box = PhotoImage(file="weather app back-img/Images/Rounded Rectangle 1.png")
    Label(root, image=round_box, bg="#E9967A").place(x=30, y=110)

    # Box text
    label1 = Label(root, text="Temperature", font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    label1.place(x=45, y=120)

    label2 = Label(root, text="Humidity", font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    label2.place(x=45, y=140)

    label3 = Label(root, text="Air Pressure", font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    label3.place(x=45, y=160)

    label4 = Label(root, text="Wind Speed", font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    label4.place(x=45, y=180)

    label5 = Label(root, text="Description", font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    label5.place(x=45, y=200)

    # Search bar
    search_bar = PhotoImage(file="weather app back-img/Images/Rounded Rectangle 3.png")
    Label(image=search_bar, bg="#E9967A").place(x=270, y=120)

    weather_image = PhotoImage(file="weather app back-img/Images/Layer 7.png")
    weather = Label(root, image=weather_image, bg="#203243")
    weather.place(x=290, y=127)

    global textfield
    textfield = Entry(root, justify="center", width=15, font=("poppins", 20, "bold"), fg="#EEE8CD", bg="#203243",
                      border=0)
    textfield.place(x=370, y=130)
    textfield.focus()

    search_icon = PhotoImage(file="weather app back-img/Images/rsz_465-4657634_search-search-png-icon-pink.png")
    Button(image=search_icon, borderwidth=0, cursor="hand2", bg="#203243", command=get_weather).place(x=645, y=125)

    # Bottom box
    frame = Frame(root, width=1500, height=180, bg="#203243")
    frame.pack(side=tk.BOTTOM)

    # Bottom boxes
    box1 = PhotoImage(file="weather app back-img/Images/Rounded Rectangle 2.png")
    box2 = PhotoImage(file="weather app back-img/Images/Rounded Rectangle 2 copy.png")

    Label(frame, image=box1, bg="#1A1A1A").place(x=50, y=20)
    Label(frame, image=box2, bg="#1A1A1A").place(x=400, y=30)
    Label(frame, image=box2, bg="#1A1A1A").place(x=500, y=30)
    Label(frame, image=box2, bg="#1A1A1A").place(x=600, y=30)
    Label(frame, image=box2, bg="#1A1A1A").place(x=700, y=30)
    Label(frame, image=box2, bg="#1A1A1A").place(x=800, y=30)
    Label(frame, image=box2, bg="#1A1A1A").place(x=900, y=30)

    # Clock (displaying time)
    clock = Label(root, text="2:30 PM", font=("poppins", 30, "bold"), fg="white", bg="#E9967A")
    clock.place(x=30, y=20)

    # Timezone
    timezone = Label(root, font=("poppins", 20), fg="white", bg="#E9967A")
    timezone.place(x=700, y=30)

    long_lat = Label(root, font=("poppins", 10), fg="white", bg="#E9967A")
    long_lat.place(x=700, y=70)

    # Weather details
    t = Label(root, font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    t.place(x=150, y=120)
    h = Label(root, font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    h.place(x=150, y=140)
    p = Label(root, font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    p.place(x=150, y=160)
    w = Label(root, font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    w.place(x=150, y=180)
    d = Label(root, font=("poppins", 11), fg="#EEE8CD", bg="#203243")
    d.place(x=150, y=200)


if __name__ == '__main__':
    create_gui()
    root.mainloop()
