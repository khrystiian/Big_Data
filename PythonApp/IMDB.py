import pyodbc
import csv
from imdbpie import Imdb
imdb = Imdb()

with open('D:\\MovieList.csv') as movieList:
    readCSV = csv.reader(movieList)
    for row in readCSV:
        con = pyodbc.connect("DRIVER={SQL Server};server=tcp:eugenb.database.windows.net,1433;"
                             "database=IMDB;Uid=eugen;Pwd=imdb2017!")
        cur = con.cursor()
        movieId = row[0]
        title = imdb.get_title_by_id(movieId)
        try:
            x = title.title
        except Exception:
            pass
        else:
            y = x.replace("'", "''")
            a = title.plot_outline
            try:
                b = a.replace("'", "''")
            except Exception:
                b = 'NULL'
            try:
                rtg = float(title.rating)
            except Exception:
                rtg = 0
            try:
                cur.execute("INSERT INTO Movies (MovieId, Title,Year,PlotSummary,PosterLink,Score) VALUES ("
                            "'{}','{}',{},'{}','{}',{})".format
                            (movieId, y, title.year, b, title.poster_url, rtg))
            except Exception:
                pass
            else:
                cur.commit()
                try:
                    for x in title.genres:
                        cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')"
                                    .format(movieId, x))
                        cur.commit()
                except Exception:
                    pass
                try:
                    cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')".format(movieId, title.genres[0]))
                except Exception:
                    pass
                try:
                    cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')".format(movieId, title.genres[1]))
                except Exception:
                    pass
                try:
                    cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')".format(movieId, title.genres[2]))
                except Exception:
                    pass
                try:
                    cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')".format(movieId, title.genres[3]))
                except Exception:
                    pass
                try:
                    cur.execute("INSERT INTO Genres (MovieId, Genre) VALUES('{}','{}')".format(movieId, title.genres[4]))
                except Exception:
                    pass
                cur.commit()
                try:
                    for review in imdb.get_title_reviews(movieId, 150):
                        try:
                            rating = float(review.rating)
                        except Exception:
                            rating = 0
                    txt = review.text.replace("'", "''")
                    cur.execute("INSERT INTO Reviews (MovieId, Score, Body) VALUES('{}', {},'{}')"
                                .format(movieId, rating, txt))
                    cur.commit()
                except Exception:
                    pass
                cur.close()
                con.close()