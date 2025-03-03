(ns template
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [include-css]]))

(defn- home-selected
  "Display main menu when Home page is selected."
  []
  [:ul
   [:li.selected
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- portfolio-selected
  "Display main menu when Netflix portfolio is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li.selected
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- netflix-stats-selected
  "Display main menu when Netflix stats page is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li.selected
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- movies-selected
  "Display main menu when Movies page is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li.selected
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- movies-stats-selected
  "Display main menu when Movie stats is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li.selected
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- movies-popularity-selected
  "Display main menu when Movie popularity is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li.selected
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- kids-movies-selected
  "Display main menu when Kids movies is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li.selected
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])

(defn- imdb-ranking-selected
  "Display main menu when IMDb ranking page is selected."
  []
  [:ul
   [:li
    [:a {:href "/"} "Home"]]
   [:li
    [:a {:href "/netflix-portfolio"} "Netflix portfolio"]]
   [:li
    [:a {:href "/netflix-statistics"} "Netflix stats"]]
   [:li
    [:a {:href "/movies"} "Movies"]]
   [:li
    [:a {:href "/movies-stats"} "Movies stats"]]
   [:li
    [:a {:href "/movies-popularity"} "Popular movies"]]
   [:li
    [:a {:href "/kids-movies"} "Kids movies"]]
   [:li.selected
    [:a {:href "/imdb-ranking-groups"} "IMDb ranking"]]])



(defn- menu
  "Display main menu and mark selected page."
  [uri]
  (cond
    (= uri "/") (home-selected)
    (= uri "/netflix-portfolio") (portfolio-selected)
    (= uri "/netflix-statistics") (netflix-stats-selected)
    (= uri "/movies") (movies-selected)
    (= uri "/movies/hulu") (movies-selected)
    (= uri "/movies/disney") (movies-selected)
    (= uri "/movies/prime") (movies-selected)
    (= uri "/movies-stats") (movies-stats-selected)
    (= uri "/movies-popularity") (movies-popularity-selected)
    (= uri "/kids-movies") (kids-movies-selected)
    true (imdb-ranking-selected))) 


(defn template-page
  "Display header, main menu, body content for all pages."
  [title uri content]
  (html
   [:head
    [:meta {:charset "UTF-8"}]
    [:link {:rel "stylesheet"
            :href "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"}]
    [:link {:rel "schortcut icon" :type "image/png" :href "/logo.png"}]
    [:title title]
    (include-css "/style.css")]
   [:body
    [:div#header
     [:div  {:style "width: 1050px !important;"}
      [:a.logo
       [:img {:src "/logo.png" :alt "FilmLo"}]]
      (menu uri)]]
    [:div#body content]]))
