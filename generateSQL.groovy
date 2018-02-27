// CREATE TABLE `score` ( `name` varchar(32) NOT NULL, `score` int(11) NOT NULL, PRIMARY KEY (`name`), KEY `score` (`score`)) ENGINE=InnoDB;
// CREATE TABLE score (name VARCHAR(32) PRIMARY KEY, score INT NOT NULL); CREATE INDEX score_score_idx ON score(score);
def count = 0
println "INSERT INTO score VALUES";
('a'..'z').each { a ->
    ('a'..'z').each { b ->
        ('a'..'z').each { c ->
            ('a'..'z').each { d ->
                ('a'..'z').each { e ->
                    final key = "$a$b$c$d$e", v = key.hashCode() % 1000;
                    println "('$key', $v)${++count == 11881376 ? ';' : ','}"
                }
            }
        }
    }
}
