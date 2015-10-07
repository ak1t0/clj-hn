# clj-hn

clj-hn is a HackerNews API wrapper.

[![Clojars Project](http://clojars.org/clj-hn/latest-version.svg)](http://clojars.org/clj-hn)

## Installation

Add the following dependency to your `project.clj` file:

    [clj-hn "1.0.3"]

## Usage

```clojure
user=> (use 'clj-hn.core)
```
### New and Top Stories
```clojure
(get-topstories)
=> [10237786 10238132 10237977 10237697 10236668 10238062 ...]
```

```clojure
(get-newstories)
=> [10238661 10238660 10238653 10238651 10238647 10238635 ...]
```
### Ask, Show and Job Stories
```clojure
(get-askstories)
=> [10343830 10338771 10344860 10343349 10337231 10342597 ...]
```

```clojure
(get-showstories)
=> [10344464 10344694 10344956 10344858 10344883 10344512 ...]
```

```clojure
(get-jobstories)
=> [10345366 10344719 10344183 10343494 10342589 10341106 ...]
```
### Item
```clojure
(get-json 8863)
=> {:time 1175714200, :type "story", :descendants 71,
    :title "My YC app: Dropbox - Throw away your USB drive",
    :kids [8952 9224 8917 8884 8887 8943 8869 8958 9005 ...],
    :id 8863, :score 111,
    :url "http://www.getdropbox.com/u/2/screencast.html",
    :by "dhouston"}
;; clojure.lang.PersistentHashMap
```

```clojure
(get-jsons [10237786 10238132 10237977])
=> ({:time 1442558404, :type "story", :descendants 15,
     :title "Pluto ‘Wows’ in Spectacular New Backlit Panorama"
     ...}
     ;; clojure.lang.PersistentHashMap
    {:time 1442566016, :type "story", :descendants 43,
     :title "Our Team Won Startup Weekend and All We Got Was a Shitty New Boss"
     ...}
    {:time 1442562884, :type "story", :descendants 5
     :title "PyNES: Write NES Games in Python"
     ...})
```


## License

Copyright © 2015 ak1t0

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
