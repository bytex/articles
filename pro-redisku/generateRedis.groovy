@Grab(group='redis.clients', module='jedis', version='2.9.0')
import redis.clients.jedis.*; final jedis = new Jedis(); def raw = 0;
jedis.select(1); jedis.flushDB(); final p = jedis.pipelined();
for (int i = 10000; i < 100000; i++) {
  final key = "a$i", v = "{\"username\": \"$key\", \"data\": \"12345678901234567890123456789012345678901234567890\"}";
  final start = key.substring(0, 3), finish = key.substring(start.length())
  p.hset(start, finish, v);
  raw += key.bytes.length + v.bytes.length
}
p.close()
"Used memory: ${jedis.info('memory').split("\n").find {it=~/used_memory/}.replaceAll('used_memory:','')}, raw data: $raw"