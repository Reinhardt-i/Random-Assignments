
import csv

csv_file = "Sports Week/IICT_Director_s_Sports_week_Player_Application_Form_Responses.csv"
interested_players = {}
# To avoid duplication, using dict to store player information (reg as the key)

with open(csv_file, mode="r", encoding="utf-8") as file:
    csv_reader = csv.reader(file)
    next(csv_reader)  # Skips header row

    for row in csv_reader:
        interested_segment = row[4].strip().lower()
        name = row[1].strip()
        phone = row[2].strip()
        reg = row[3].strip()

        if "chess" in interested_segment:
            if reg not in interested_players:
                interested_players[reg] = f"{name}  "
with open("Sports Week/Round 1(knockout).txt", "w") as output_file:
    for player_info in interested_players.values():
        output_file.write(player_info + "\n")

