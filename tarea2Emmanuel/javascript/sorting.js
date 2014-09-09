/**
 * Autor: Emmanuel Arias Soto
 * 
 */
 /**Class List**/
	/// Constructor
	function List(maxLength){
		this.node = [];	
	}
	
	List.prototype.addFirst = function(value){
       this.node.unshift(value);
	}
	
	List.prototype.addLast = function(value){
       this.node.push(value); 
	}

	List.prototype.getValueByIndex = function(i){
		v = this.node[i];
		return v;
	}

	//returns only the position of the first match
	List.prototype.getIndexOf = function(value){
		index = this.node.indexOf(value);
		return index;
	}
	
	List.prototype.exists = function(value){
		index = this.node.indexOf(value);
		if(index == -1)
			return false;
		else
			return true;
	}

	List.prototype.modify = function(index, v){
		this.node[index] = v;
	}	

	List.prototype.deleteByIndex = function(index){
		this.node.splice(index, 1);
	}

	List.prototype.length = function(){
		return this.node.length;
	}
	List.prototype.print = function(value){
       s = "";
		for	(index = 0; index < this.node.length; index++) {
			s += this.node[index] + " ";
		}	
        return s;
	}
	/**End of Class List**/

	/**Lists Sorter**/
	swap = function(l, i1, i2){
		aux = l.getValueByIndex(i1);
		l.modify(i1, l.getValueByIndex(i2));
		l.modify(i2, aux);
	}

	sortByInsertion = function(l){
		for(i = 1; i < l.length(); i++){
			key = l.getValueByIndex(i);
			j = i;
			while(j > 0 && l.getValueByIndex(j-1) > key){
				l.modify(j, l.getValueByIndex(j-1));
				j--;
			}
			l.modify(j, key);
		}
		return l;
	}
	sortByBubble = function(l){
        for(i = 0; i < l.length()-1; i++){
            for(j = 0; j < l.length()-1 - i; j++){
                if(l.getValueByIndex(j) > l.getValueByIndex(j+1)){
                    swap(l, j, j+1);
                }
            }
        }
        return l;
	}

	sortBySelection = function(l){
        for(i = 0; i < l.length()-1; i++){
        	smallestIndex = i;
            for(j = i+1; j < l.length(); j++){
                if(l.getValueByIndex(j) < l.getValueByIndex(smallestIndex)){
                	smallestIndex = j;
                }
            }
            swap(l, i, smallestIndex);
        } 
        return l;
	}

	sortPartition = function(l, start, end){
        pivot = end,
        pivotIndex = start,
        tmp = start;

        pivotValue = l.getValueByIndex(pivot);

        for(i = start; i < end; i++){
        	if(l.getValueByIndex(i) <= pivotValue){
        		swap(l, i, pivotIndex);
        		pivotIndex++;
        	}
        }
        swap(l, pivotIndex, pivot);
        return pivotIndex;
    }

    sortByQuickSort = function(l){
    	doTheQuickSort(l, 0, l.length()-1);
    	return l;
    }
    doTheQuickSort = function(l, start, end){
    	 if(start != null && end != null && start < end){
    	 	pivotIndex = sortPartition(l, start, end);
    	 	doTheQuickSort(l, pivotIndex+1, end);
    	 	doTheQuickSort(l, start, pivotIndex-1);
    	 }
    }

    makeGaps = function(l){
    	var gaps = [];
    	gap = l;
    	while(gap > 0){
            gaps.push(gap);
            gap = (gap/2 >>0 );
        }
    	return gaps;
    }

    sortByShell = function(l){
    	gaps = makeGaps(l.length());
    	for(k = 0; k < gaps.length; k++){
    		gap = gaps[k];
    		for (i = gap; i < l.length(); i++){
    			tmp = l.getValueByIndex(i);
    			for (j = i; j >= gap && l.getValueByIndex(j-gap) > tmp; j -= gap){
    				l.modify(j, l.getValueByIndex(j - gap));
    			}
				l.modify(j, tmp);
    		}
    	}
    	return l;
        }
        /** Plugin from http://lions-mark.com/jquery/scrollTo/ **/
        $.fn.scrollTo = function( target, options, callback ){
          if(typeof options == 'function' && arguments.length == 2){ callback = options; options = target; }
          var settings = $.extend({
          scrollTarget  : target,
          offsetTop     : 50,
          duration      : 500,
          easing        : 'swing'
          }, options);
          return this.each(function(){
          var scrollPane = $(this);
          var scrollTarget = (typeof settings.scrollTarget == "number") ? settings.scrollTarget : $(settings.scrollTarget);
          var scrollY = (typeof scrollTarget == "number") ? scrollTarget : scrollTarget.offset().top + scrollPane.scrollTop() - parseInt(settings.offsetTop);
          scrollPane.animate({scrollTop : scrollY }, parseInt(settings.duration), settings.easing, function(){
          if (typeof callback == 'function') { callback.call(this); }
          });
          });
          }
          /**End of plugin**/
