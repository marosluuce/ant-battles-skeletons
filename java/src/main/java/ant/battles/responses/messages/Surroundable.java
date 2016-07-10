package ant.battles.responses.messages;

import ant.battles.responses.Food;
import ant.battles.responses.messages.AntMessage;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = AntMessage.class, name = "ant"),
              @JsonSubTypes.Type(value = Food.class, name = "food")})
public interface Surroundable {
}
