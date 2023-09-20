import csv

csv_file = "Sports Week/IICT_Director_s_Sports_week_Player_Application_Form_Responses.csv"
interested_players = []

with open(csv_file, mode="r", encoding="utf-8") as file:
    csv_reader = csv.reader(file)
    next(csv_reader)  # Skips header row

    for row in csv_reader:
        interested_segment = row[4].strip().lower()
        name = row[1].strip()
        phone = row[2].strip()
        reg = row[3].strip()

        if "chess" in interested_segment:
            interested_players.append(f"Name: {name}, Phone: {phone}, Registration: {reg}")

with open("Sports Week/chess_players.txt", "w") as output_file:
    for player_info in interested_players:
        output_file.write(player_info + "\n")

print("Interested players' information has been written to chess_players.txt.")
